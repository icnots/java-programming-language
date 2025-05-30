import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import book.BookCollectionStructureTest;
import book.BookStructureTest;
import book.CoverTypeStructureTest;
import book.DamagedBookStructureTest;
import book.EBookStructureTest;
import book.InvalidBookExceptionStructureTest;
import book.PrintedBookStructureTest;
import printed.material.BookTest;
import printed.material.specific.EBookTest;
import printed.material.specific.PrintedBookTest;

@Suite
@SelectClasses({
    BookStructureTest.class,
    BookTest.class,
    InvalidBookExceptionStructureTest.class,

    EBookStructureTest.class,
    EBookTest.class,
    CoverTypeStructureTest.class,
    PrintedBookStructureTest.class,
    PrintedBookTest.class,

    DamagedBookStructureTest.class,
    BookCollectionStructureTest.class,
})
public class BookSuite {}
