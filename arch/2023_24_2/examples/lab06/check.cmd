:<<"::NONWINDOWSSCRIPT"
@ECHO OFF
GOTO :WINDOWSSCRIPT

::NONWINDOWSSCRIPT
minjavavsn=17
recjavavsn=21

# check Java version
javavsn=`java -fullversion 2>&1 | cut -d'"' -f2 | sed '/^1\./s///' | cut -d'.' -f1`
if [[ "$javavsn" -lt "$minjavavsn" ]]; then
    echo "Exiting    : Java ${minjavavsn}+ required, Java ${javavsn} found"
    echo "Recommended: Remove Java ${javavsn}, install Java ${recjavavsn} from https://www.azul.com/downloads/"
    exit 1
fi

# check required files
missing=0
[ ! -f "junit5all.jar" ] && echo "Missing file: junit5all.jar" && missing=1
[ ! -f "checkthat.jar" ] && echo "Missing file: checkthat.jar" && missing=1
[ ! -f "checkagent.jar" ] && echo "Missing file: checkagent.jar" && missing=1
[[ "$missing" -eq "1" ]] && exit 1

if [ $# -ge 2 ]; then
    # check arg file exists
    [ ! -f "$1" ] && echo Missing argument file: "$name" && exit 1

    TARGET1=$1
    TARGET2=$2
    PROPS=${3-}
    OPTS=${4-}

    if [[ "$TARGET2" == *"StructureTest" ]]; then
        echo "Structural tester: compiling and running $TARGET2"
    elif [[ "$TARGET2" == *"Suite" ]]; then
        echo "Test suite: compiling and running $TARGET2"
    else
        echo "Functional tester: compiling and running $TARGET2"
    fi

    echo javac -cp ".:junit5all.jar:checkthat.jar" "${TARGET1}"
    javac -cp ".:junit5all.jar:checkthat.jar" "${TARGET1}"
    retVal=$?
    [[ $retVal -ne 0 ]] && echo "Exiting: Java compilation failed with error code $retVal" && exit $retVal

    echo java ${PROPS} -javaagent:checkagent.jar -jar junit5all.jar execute ${OPTS} -E junit-vintage --disable-banner -cp . -cp checkthat.jar -c "${TARGET2}"
    java ${PROPS} -javaagent:checkagent.jar -jar junit5all.jar execute ${OPTS} -E junit-vintage --disable-banner -cp . -cp checkthat.jar -c "${TARGET2}"

    exit 0
fi

# usage
echo "Usage: check.bat <path of tester file> <tester class> [CheckThat options] [JUnit properties]"
echo "Useful CheckThat options:"
echo "   -Dlang=HU or -Dlang=EN  For structural tester error messages."
echo "   -Dsummary=time/full     Use either time or full to see more JUnit summary details."
echo "   -Derrors=verbose        If you really, REALLY want to see the full stack trace."
echo "Useful JUnit properties:"
echo "   --disable-ansi-colors   For monochrome terminals."
echo
echo "Note: in PowerShell terminals, options have to be surrounded using this very silly syntax:"
echo "   '\"-Dlang=EN\"'"
echo
echo "Note: passing more than one option can be tricky."
echo "Suggested: see the executed java and javac commands and manually modify them."
exit 1


:WINDOWSSCRIPT
set minjavavsn=17
set recjavavsn=21

if "%~1"=="" goto USAGE

REM check Java version
for /f tokens^=2^ delims^=.-_+^" %%j in ('java -fullversion 2^>^&1') do set "javavsn=%%j"
if %javavsn% LSS %minjavavsn% (
    echo Exiting    : Java %minjavavsn%+ required, Java %javavsn% found
    echo Recommended: Remove Java %javavsn% (and possible other old versions^), install Java %recjavavsn% from https://www.azul.com/downloads/
    goto END
)

REM check required files
set missing=0
for %%i in ("checkthat.jar" "checkagent.jar" "junit5all.jar" "%~1") do (
    if not exist "%%i" (
        echo Missing required file: %%i
        set missing=1
    )
)

if "%missing%"=="1" goto END
if "%~2"=="" goto USAGE

REM check arg file exists
if not exist "%~1" (
    echo Missing argument file: %~1
    goto END
)

set TARGET1="%~1"
set TARGET2="%~2"
set PROPS=
set OPTS=
if not "%~3"=="" (
    set PROPS="%~3"
)
if not "%~4"=="" (
    set OPTS="%~4"
)


if not "x%TARGET2:StructureTest=%"=="x%TARGET2%" (
    echo Structural tester: compiling and running %TARGET2%
) else (
    if not "x%TARGET2:Suite=%"=="x%TARGET2%" (
        echo Test suite: compiling and running %TARGET2%
    ) else (
        echo Functional tester: compiling and running %TARGET2%
    )
)


@ECHO ON

javac -cp ".;junit5all.jar;checkthat.jar" %TARGET1%

: Stops the batch file if there was a compilation error
@if %ERRORLEVEL% NEQ 0 (
    echo Exiting: Java compilation failed with error code %ERRORLEVEL%
    exit /b %ERRORLEVEL%
)

java %PROPS% -javaagent:checkagent.jar -jar junit5all.jar execute %OPTS% -E junit-vintage --disable-banner -cp . -cp checkthat.jar -c %TARGET2%

@ECHO OFF
goto END


:USAGE
echo Usage: check.bat ^<path of tester file^> ^<tester class^> [CheckThat options] [JUnit properties]
echo Useful CheckThat options:
echo    -Dlang=HU or -Dlang=EN  For structural tester error messages.
echo    -Dsummary=time/full     Use either time or full to see more JUnit summary details.
echo    -Derrors=verbose        If you really, REALLY want to see the full stack trace.
echo Useful JUnit properties:
echo    --disable-ansi-colors   For monochrome terminals.
echo[
echo Note: in PowerShell terminals, options have to be surrounded using this very silly syntax:
echo    '"-Dlang=EN"'
echo[
echo Note: passing more than one option can be tricky.
echo Suggested: see the executed java and javac commands and manually modify them.

:END
