// purpose : nghiep vu quan li thong tin nhan su thuoc doi tuong truong phong
public class TruongPhong extends NhanSu {
	// Constant
	static final int LUONG_TRUONG_PHONG = 200; 
	// Attributes 
	private int soLuongNhanVienDuoiQuyen;
	// Get/set method
	public int getSoLuongNhanVienDuoiQuyen() {
		return soLuongNhanVienDuoiQuyen;
	}
	// Constructor
	public TruongPhong() {
		this.luongMotNgay = LUONG_TRUONG_PHONG;
	}

	public TruongPhong(String maSo, String hoTen, String soDienTHoai, int soNgayLamViec) {
		super(maSo, hoTen, soDienTHoai, soNgayLamViec);
	this.luongMotNgay = LUONG_TRUONG_PHONG;
	}
	// input / output methods
	@Override
	public void inputInfo() {
		super.inputInfo();
	}
	@Override
	public String outputInfo() {
		super.outputInfo();
		String info = super.outputInfo()+"So nhan vien duoi quyen :"+this.soLuongNhanVienDuoiQuyen;
		return info;
	}

	// business method
	public void themMotNhanVienDuoiQuyen() {
		this.soLuongNhanVienDuoiQuyen++;
		
	}
	public void xoaMotNhanVienDuoiQuyen() {
		this.soLuongNhanVienDuoiQuyen--;
	}
	@Override
	public void tinhLuong() {
		this.tienLuong = luongMotNgay*soNgayLamViec+100*soLuongNhanVienDuoiQuyen;
	}
	
	
	

}
