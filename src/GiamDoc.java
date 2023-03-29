// purpose : quan li thong tin Giam doc thuoc nhan su
public class GiamDoc extends NhanSu {
	static final int LUONG_GIAM_DOC = 300;
	// Attributes 
	private float coPhanCongTy;
	// get/set methods
	public float getCoPhanCongTy() {
		return coPhanCongTy;
	}

	public void setCoPhanCongTy(float coPhanCongTy) {
		this.coPhanCongTy = coPhanCongTy;
		
	}
	// Contructor
	public GiamDoc() {
		this.luongMotNgay = LUONG_GIAM_DOC;
		// TODO Auto-generated constructor stub
	}

	public GiamDoc(String maSo, String hoTen, String soDienTHoai, int soNgayLamViec,float coPhanCongTy) {
		super(maSo, hoTen, soDienTHoai, soNgayLamViec);
		this.coPhanCongTy = coPhanCongTy;
		this.luongMotNgay = LUONG_GIAM_DOC;
		
	}
	// input/ output methods
	@Override
	public void inputInfo() {
		super.inputInfo();
		System.out.print("Nhap so % co phan cong ty ( <100 ) :");
		do {
			this.coPhanCongTy = Scan.scanFloatNumber();
		}while(this.coPhanCongTy<0||this.coPhanCongTy>100);
		
	}
	public String outputInfo() {
		
		String info = super.outputInfo()+"So co phan cong ty :"+this.coPhanCongTy+" %";
		return info;
		
	}
	// business method
	@Override
	public void tinhLuong () {
			this.tienLuong = luongMotNgay*soNgayLamViec;
	}

}
