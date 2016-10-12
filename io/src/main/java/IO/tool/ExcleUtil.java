package IO.tool;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;

import jxl.Image;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class ExcleUtil {

	@SuppressWarnings("rawtypes")
	public static void excleOut(ArrayList list, String path) {

		WritableWorkbook book = null;
		try {
			book = Workbook.createWorkbook(new File(path));
			WritableSheet sheet = book.createSheet("sheet", 0);
			for (int i = 0; i < list.size(); i++) {
				Object obj = list.get(i);
				// 获取运行时对象
				Class cl = obj.getClass();
				// 获取所有的属性
				Field[] fi = cl.getDeclaredFields();
				for (int j = 0; j < fi.length; j++) {
					// 设置每个属性的访问权限
					fi[j].setAccessible(true);
					// 利用属性放入对象，访问到这个属性的值
					Label la = new Label(j, i, String.valueOf(fi[j].get(obj)));
					sheet.addCell(la);
				}

			}
			book.write();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				book.close();
			} catch (WriteException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked", "unused", "resource" })
	public static ArrayList excleIn(Class cl, String path) {

		FileOutputStream os = null;
		ArrayList list = new ArrayList();
		Workbook book = null;
		try {
			book = Workbook.getWorkbook(new File(path));
			Sheet sheet = book.getSheet(0);
			Field[] fi = cl.getDeclaredFields();
			// System.out.println("excleIn------------->" + sheet.getRows());

			for (int i = 0; i < sheet.getRows(); i++) {
				Object obj = cl.newInstance();
				// System.out.println("excleIn------------->" +
				// sheet.getRows());
				for (int j = 0; j < fi.length; j++) {
					// 设置每个属性的访问权限
					fi[j].setAccessible(true);
					String str = sheet.getCell(j, i).getContents();
					// 属性类型转化写入
					if (fi[j].getType().toString()
							.equals("class java.lang.String")) {
						fi[j].set(obj, str);
//						// 设置图片
//						if (fi[j]
//								.toString()
//								.equals("public java.lang.String IO.model.CompanyInfo.picture")) {
//							// 图片数量
//							int imgNum = sheet.getNumberOfImages();
//							// 从哪个开始
//							int start = 0;
//							// 每次读三张
//							int end = start + 3;
//							// 循环图片
//							for (int k = start; k < end; k++) {
//								start = end;
//								// 不能超过总数
//								if (end > imgNum) {
//									end = imgNum;
//								}
//
//								Image image = sheet.getDrawing(k);
//								byte[] imageData = image.getImageData();
//								// 图片名称
//								String fileName = image.getImageFile()
//										.getName().trim()
//										+ ".jpg";
//								System.out.println("fileName:" + fileName);
//								// File file = new File(path + "/" + fileName);
//
//								// os = new FileOutputStream(file);//
//								// 建立一个上传文件的输出流
//								// os.write(imageData, 0, imageData.length);//
//								// 将文件写入服务器
//								fi[j].set(obj, imageData.toString());
//							}
//						}
					} else if (fi[j].getType().toString().equals("int")) {
						fi[j].setInt(obj, Integer.valueOf(str));
					} else {

					}
				}
				list.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			book.close();
		}
		return list;
	}
}
