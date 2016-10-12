package IO.model;

public class CompanyInfo {

	// public String id;
	// 公司名称
	public String name;
	// 公司信息
	public String info;
	// 相关图片
	// public String pictureUrl;
	// 图片
	public String picture;

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	// public String getPictureUrl() {
	// return pictureUrl;
	// }
	//
	// public void setPictureUrl(String pictureUrl) {
	// this.pictureUrl = pictureUrl;
	// }

	// public String getId() {
	// return id;
	// }
	//
	// public void setId(String id) {
	// this.id = id;
	// }

	public CompanyInfo() {
	}

	public CompanyInfo(String name, String info, String picture) {
		this.name = name;
		this.info = info;
		this.picture = picture;
	}

	@Override
	public String toString() {
		return "CompanyInfo name=" + name + ", info=" + info + ", picture="
				+ picture + "";
	}

	// @Override
	// public String toString() {
	// return "companyInfo [id=" + id + ", name=" + name + ", info=" + info
	// + ", pictureUrl=" + pictureUrl + ", picture=" + picture + "]";
	// }

}
