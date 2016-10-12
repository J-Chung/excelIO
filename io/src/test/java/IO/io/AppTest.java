package IO.io;

import java.util.ArrayList;

import IO.model.Book;
import IO.model.CompanyInfo;
import IO.tool.ExcleUtil;
import junit.framework.TestCase;

public class AppTest extends TestCase {

	public void book() {

		ArrayList<Book> list = ExcleUtil.excleIn(Book.class, "e:/book.xls");
		for (Book book : list) {
			System.out.println(book.toString());
		}
	}

	public void company() {

		ArrayList<CompanyInfo> list = ExcleUtil.excleIn(CompanyInfo.class,
				"e:/公司信息.xls");
		for (CompanyInfo info : list) {
			System.out.println(info.toString());
		}
	}
}
