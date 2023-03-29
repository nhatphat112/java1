// purpose : quan ly thong tin nhan vien thuoc nhan su
public class NhanVien extends NhanSu {
	// Constant
	static final int LUONG_NHAN_VIEN = 100;
	// Attributes
	private TruongPhong truongPhongQuanLy;
	// get / set methods
	
	public TruongPhong getTruongPhongQuanLy() {
		return truongPhongQuanLy;
	}

	public void setTruongPhongQuanLy(TruongPhong truongPhongQuanLy) {
		this.truongPhongQuanLy = truongPhongQuanLy;
	}
	// Constructor
	public NhanVien() {
		this.luongMotNgay = LUONG_NHAN_VIEN;
	}

	public NhanVien(String maSo, String hoTen, String soDienTHoai, int soNgayLamViec) {
		super(maSo, hoTen, soDienTHoai, soNgayLamViec);
		// TODO Auto-generated constructor stub
	}
	// input output method
	@Override
	public void inputInfo() {
		super.inputInfo();
	}
	public String outputInfo() {
		
		if(this.truongPhongQuanLy!=null) {
			String text = (super.outputInfo()+"Ten truong phong :"+this.truongPhongQuanLy.hoTen+"\t Ma So :"+this.truongPhongQuanLy.getMaSo());
			String info = String.format("%-30s", text);
			return info;
		}else
			return super.outputInfo();
	}
	// business method
	@Override
	public void tinhLuong() {
		this.tienLuong = luongMotNgay *soNgayLamViec;
	}
	
	

}
