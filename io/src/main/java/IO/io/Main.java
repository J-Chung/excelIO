package IO.io;

import java.util.ArrayList;

import IO.model.Book;
import IO.model.CompanyInfo;
import IO.tool.ExcleUtil;

public class Main {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		// ArrayList<Book> books = new ArrayList<Book>();
		// Book bo1 = new Book(1,"月子","生活");
		// Book bo2 = new Book(1,"日子","生活");
		// books.add(bo1);
		// books.add(bo2);
		//
		// ExcleUtil.excleOut(books, "e:/book.xls");

		// ArrayList<Book> list = ExcleUtil.excleIn(Book.class, "e:/book.xls");
		// for (Book book : list) {
		// System.out.println(book.toString());
		// }

		ArrayList<CompanyInfo> list = ExcleUtil.excleIn(CompanyInfo.class, "e:/公司信息.xls");
		for (CompanyInfo info : list) {
			System.out.println(info.toString());
		}
	}
}
