package com.easybuy.entity;
//��Ʒ��
public class easybuy_product {
	private int id;//��Ʒ���
	private String name;//��Ʒ����
	private String description;//��Ʒ����
	private float price;//��Ʒ����
	private int stock;//��Ʒ���
	private int categoryLevel1;//����һ������id
	private int categoryLevel2;//������������id
	private String categoryLevel3;//������������id
	private String fileName;//�ϴ����ļ���
	private String isDelete;//�Ƿ�ɾ�� 1.ɾ�� 2.δɾ��
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getCategoryLevel1() {
		return categoryLevel1;
	}
	public void setCategoryLevel1(int categoryLevel1) {
		this.categoryLevel1 = categoryLevel1;
	}
	public int getCategoryLevel2() {
		return categoryLevel2;
	}
	public void setCategoryLevel2(int categoryLevel2) {
		this.categoryLevel2 = categoryLevel2;
	}
	public String getCategoryLevel3() {
		return categoryLevel3;
	}
	public void setCategoryLevel3(String categoryLevel3) {
		this.categoryLevel3 = categoryLevel3;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
	
	

}
