import java.io.Serializable;

// mục đích : nghiep vu quan li thong tin nhan su cua cong ty  
public abstract class NhanSu implements Serializable {
	// Attributes
	protected String maSo;
	protected String hoTen;
	protected String soDienThoai;
	protected int soNgayLamViec;
	protected int luongMotNgay;
	protected double tienLuong;
	// Get/set method
	
	public String getMaSo() {
		return maSo;
	}

	public void setMaSo(String maSo) {
		this.maSo = maSo;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getSoDienTHoai() {
		return soDienThoai;
	}

	public void setSoDienTHoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public int getSoNgayLamViec() {
		return soNgayLamViec;
	}

	public void setSoNgayLamViec(int soNgayLamViec) {
		this.soNgayLamViec = soNgayLamViec;
	}

	public int getLuongMotNgay() {
		return luongMotNgay;
	}

	public double getTienLuong() {
		return tienLuong;
	}
	// Construction 
	
	public NhanSu() {
		
	}

	public NhanSu(String maSo, String hoTen, String soDienTHoai, int soNgayLamViec) {
		super();
		this.maSo = maSo;
		this.hoTen = hoTen;
		this.soDienThoai = soDienTHoai;
		this.soNgayLamViec = soNgayLamViec;
	}
	// input / output methods
	public void inputInfo() {
		System.out.print("Nhap ma so :");
		this.maSo = Scan.scan.nextLine();
		System.out.print("Nhap ho ten :");
		this.hoTen = Scan.scan.nextLine();
		System.out.print("Nhap so dien thoai :");
		this.soDienThoai = Scan.scan.nextLine();
		do {

			System.out.print("Nhap so ngay lam viec :");
			this.soNgayLamViec = Scan.scanInteger();
		}while(this.soNgayLamViec<0);
		
	}
	public String outputInfo() {
//		System.out.print("Ma So :"+this.maSo+
//							"\t Ho Ten :"+this.hoTen+ 
//							"\t So Dien Thoai :"+this.soDienThoai+ 
//							"\t So ngay lam viec :"+this.soNgayLamViec+
//							"\t Luong mot ngay :"+this.luongMotNgay+ 
//							"\t Tien luong :"+this.tienLuong+ 
//							"\t");
		String info = String.format("%-10s%-30s%-20s%-17s%-19s%-15s",this.maSo,this.hoTen,this.soDienThoai,String.valueOf(this.soNgayLamViec),String.valueOf(this.luongMotNgay),String.valueOf(this.tienLuong));
		return info;
	}
	// business methods
	public abstract void tinhLuong();
	


}
