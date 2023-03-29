import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

// purpose : quan li thong tin cua cong ty
public class CongTy {
	// Attributes
	private String tenCongTy;
	private String maSoThue;
	private double doanhThuThang = 0;
	static private ArrayList<NhanSu> dsNhanSu;
	private ArrayList<String> dsMenu;
	// get/ set method

	public String getTenCongTy() {
		return tenCongTy;
	}

	public void setTenCongTy(String tenCongTy) {
		this.tenCongTy = tenCongTy;
	}

	public String getMaSoThue() {
		return maSoThue;
	}

	public void setMaSoThue(String maSoThue) {
		this.maSoThue = maSoThue;
	}

	public double getDoanhThuThang() {
		return doanhThuThang;
	}

	public void setDoanhThuThang(double doanhThuThang) {
		this.doanhThuThang = doanhThuThang;
	}

	public ArrayList<NhanSu> getDsNhanSu() {
		return dsNhanSu;
	}

	public void setDsNhanSu(ArrayList<NhanSu> dsNhanSu) {
		this.dsNhanSu = dsNhanSu;
	}
	// contructor

	public CongTy() {
		dsNhanSu = new ArrayList<NhanSu>();
	}

	public CongTy(String tenCongTy, String maSoThue, double doanhThuThang, ArrayList<NhanSu> dsNhanSu) {
		super();
		this.tenCongTy = tenCongTy;
		this.maSoThue = maSoThue;
		this.doanhThuThang = doanhThuThang;
		this.dsNhanSu = dsNhanSu;
	}

	// input / output method
	public void inputCompanyInformation() {
		System.out.print("Nhap ten cong ty :");
		this.tenCongTy = Scan.scan.nextLine();
		System.out.print("Nhap ma so thue :");
		this.maSoThue = Scan.scan.nextLine();
		System.out.print("Nhap doanh thu thang :");
		{
			this.doanhThuThang = Scan.scanDoubleNumber();
		}
		while (this.doanhThuThang < 0)
			;
	}

	public float soCoPhanHopLe() {
		float coPhan = 100;
		for (NhanSu ns : this.dsNhanSu) {
			if (ns instanceof GiamDoc) {
				GiamDoc gd = (GiamDoc) ns;
				coPhan -= gd.getCoPhanCongTy();
			}
		}
		return coPhan;
	}

	public void outputCompanyInfo() {
		System.out.println("********** Company Information *********");
		System.out.println("Company Name :" + this.tenCongTy);
		System.out.println("Company Tax Code :" + this.maSoThue);
		System.out.println("Company monthly revenue :" + this.doanhThuThang);
	}

	public void outputCongTy() {
		outputCompanyInfo();

		outputDsNhanSu("Danh Sach Cong Ty", this.dsNhanSu);

	}

	public void outputDsNhanSu(String title, ArrayList<NhanSu> NhanSu) {
		title = String.format("%60s", title);
		System.out.println(title);
		for (NhanSu ns : NhanSu) {
			ns.outputInfo();
		}
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println(String.format("%-5s%-10s%-35s%-10s%-20s%-20s%-25s%-30s", "STT", "Ma So", "Ho Ten", "So DT",
				"So Ngay Lam Viec", "Luong Mot Ngay", "Tien Luong", "Ghi Chu"));
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------------------------------------------------------");

		for (int i = 0; i < NhanSu.size(); i++) {
			System.out.println(String.format("%-7s%-2s", " " + (i + 1), NhanSu.get(i).outputInfo()));
			System.out.println(
					"-------------------------------------------------------------------------------------------------------------------------------------------------------------------");

		}
	}

	public void outputDsGiamDoc(String title, ArrayList<GiamDoc> dsGiamDoc) {
		title = String.format("%60s", title);
		System.out.println(title);
		for (NhanSu ns : dsGiamDoc) {
			ns.outputInfo();
		}
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println(String.format("%-5s%-10s%-35s%-10s%-20s%-20s%-25s%-30s", "STT", "Ma So", "Ho Ten", "So DT",
				"So Ngay Lam Viec", "Luong Mot Ngay", "Tien Luong", "Ghi Chu"));
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------------------------------------------------------");

		for (int i = 0; i < dsGiamDoc.size(); i++) {
			System.out.println(String.format("%-7s%-2s", " " + (i + 1), dsGiamDoc.get(i).outputInfo()));
			System.out.println(
					"-------------------------------------------------------------------------------------------------------------------------------------------------------------------");

		}
	}

	public void inputDsNhanSu() {
		System.out.println("***** Nhap Danh Sach Nhan Su ******");
		boolean flag = true;
		int chooice = 0;
		NhanSu ns;
		do {
			System.out.println("0. Thoat");
			System.out.println("1. Nhan Vien");
			System.out.println("2. Truong Phong");
			System.out.println("3. Giam Doc");
			System.out.print("Nhap lua chon :");
			chooice = Scan.scanInteger();
			switch (chooice) {
			case 0:
				flag = false;
				break;
			case 1:
				ns = new NhanVien();
				do {
					ns.inputInfo();
					if (kiemTraNhanSuTonTaiTheoMa(ns.getMaSo()))
						System.out.println("Nhan Su da ton tai!");
				} while (kiemTraNhanSuTonTaiTheoMa(ns.getMaSo()));

				((NhanVien) ns).tinhLuong();
				this.dsNhanSu.add(ns);
				break;
			case 2:
				ns = new TruongPhong();
				do {
					ns.inputInfo();
					if (kiemTraNhanSuTonTaiTheoMa(ns.getMaSo()))
						System.out.println("Nhan Su da ton tai!");
				} while (kiemTraNhanSuTonTaiTheoMa(ns.getMaSo()));
				((TruongPhong) ns).tinhLuong();
				this.dsNhanSu.add(ns);
				break;
			case 3:
				ns = new GiamDoc();

				do {
					ns.inputInfo();
					if (((GiamDoc) ns).getCoPhanCongTy() > soCoPhanHopLe())
						System.out.println("So co phan khong hop le! (<=" + soCoPhanHopLe() + ")");
					if (kiemTraNhanSuTonTaiTheoMa(ns.getMaSo()))
						System.out.println("Nhan Su da ton tai!");
				} while (kiemTraNhanSuTonTaiTheoMa(ns.getMaSo()) || ((GiamDoc) ns).getCoPhanCongTy() > soCoPhanHopLe());
				((GiamDoc) ns).tinhLuong();
				this.dsNhanSu.add(ns);
				break;

			}
		} while (flag);
	}

	// check ms nhan su ton tai
	public boolean kiemTraNhanSuTonTaiTheoMa(String maNS) {
		for (NhanSu ns : this.dsNhanSu) {
			if (ns.getMaSo().equalsIgnoreCase(maNS)) {
				return true;
			}
		}
		return false;
	}

	// Menu
	public void Menu() {
		boolean flag = true;
		String fileName;
		do {
			int choose;
			outputMenu("Chuong Trinh Quan Ly Cong Ty ");
			do {
				System.out.print("Moi nhap lua chon :");
				choose = Scan.scanInteger();
				if (choose < 0 || choose > 14)
					System.out.println("Lua chon khong hop le, nhap lai !");
			} while (choose < 0 || choose > 14);
			switch (choose) {
			case 0:
				System.out.println("Exit");
				flag = false;
				break;
			case 1:
				System.out.print("Nhap ten file de doc (enter de bo qua) :");
				fileName = Scan.scan.nextLine();
				inputFile(fileName);
				break;
			case 2:
				System.out.print("Nhap ten file de luu (enter de bo qua) :");
				fileName = Scan.scan.nextLine();
				outputFile(fileName);
				break;
			case 3:
				System.out.println("**** Nhap thong tin cong ty *****");
				inputCompanyInformation();
				break;
			case 4:
				phanBoNhanVienVaoTruongPhong();
				break;
			case 5:
				inputDsNhanSu();
				break;
			case 6:
				xoaNhanSuTheoMa();
				break;
			case 7:
				outputCongTy();
				break;
			case 8:
				tinhVaXuatTongLuongChoToanBoCongTy();
				break;
			case 9:
				nhanVienThuongCoLuongCaoNhat();
				break;
			case 10:
				truongPhongCoSoLuongNhanVienDuoiQuyenNhieuNhat();
				break;
			case 11:
				sapXepNhanVienToanBoCongTyTheoThuTuABC();
				break;
			case 12:
				sapXepNhanSuTheoLuongGiamDan();
				break;
			case 13:
				giamDocCoSoLuongCoPhanNhieuNhat();
				break;
			case 14:
				tinhVaXuatTongThuNhapCuaTungGiamDoc();
				break;
			}

		} while (flag);
	}

	public void outputMenu(String title) {
		String hr = "------------------------------------------------------------------------";
		System.out.println(String.format("%50s", title));
		if(dsMenu == null) addDsMenu();
		System.out.println(hr);
		for(int i =0;i<dsMenu.size();i++) {
			formMenu(String.valueOf(i),dsMenu.get(i));
		}
		System.out.println(hr);

	}
	public void addDsMenu() {
		dsMenu = new ArrayList<String>();
		dsMenu.add("Thoat");
		dsMenu.add("Doc File");
		dsMenu.add("Luu File");
		dsMenu.add("Nhap Thong Tin Cong Ty");
		dsMenu.add("Phan Bo Nhan Vien Vao Truong Phong");
		dsMenu.add("Them Thong Tin Nhan Su");
		dsMenu.add("Xoa Thong Tin Nhan Su");
		dsMenu.add("Xuat Thong Tin Toan Bo Nguoi Trong Cong Ty");
		dsMenu.add("Tinh Va Xuat Tong Luong Cho Toan Cong Ty");
		dsMenu.add("Tim Nhan Vien Thuong Co Luong Cao Nhat");
		dsMenu.add("Tim Truong Phong Co So Luong Nhan Vien Duoi Quyen Nhieu Nhat");
		dsMenu.add("Sap Xep Nhan Vien Toan Cong Ty Theo Thu Tu ABC");
		dsMenu.add("Sap Xep Nhan Vien Toan Cong Ty Theo Thu Tu Luong Giam Dan");
		dsMenu.add("Tim Giam Doc Co So Luong Co Phan Nhieu Nhat");
		dsMenu.add("Tinh Va Xuat Tong Thu Nhap Cua Tung Giam Doc");
		
	}
	public void formMenu(String stt,String title) {
		
		String text = String.format("%-1s%-10s%-60s%-10s","|", stt,title,"|")	;
		System.out.println(text);
		System.out.println();
		}

	// Business methods
	public void tinhVaXuatTongThuNhapCuaTungGiamDoc() {
		double loiNhuanCongTy = tinhLoiNhuanCongTy();
		System.out.println("Loi nhuan cua cong ty :" + loiNhuanCongTy);
		System.out.println("Tong luong cua cong ty :" + tinhTongLuongChoToanBoCongTy());
		for (NhanSu ns : this.dsNhanSu) {
			if (ns instanceof GiamDoc) {
				GiamDoc gd = (GiamDoc) ns;
				gd.outputInfo();
				System.out.println("Ho Ten Giam Doc :" + gd.getHoTen());
				System.out.println("Tong Thu Nhap :" + tinhTongThuNhapGiamDoc(gd, loiNhuanCongTy) + "VNĐ");
			}
		}
	}

	public void sapXepNhanVienToanBoCongTyTheoThuTuABC() {
		for (int i = 0; i < this.dsNhanSu.size() - 1; i++) {
			for (int j = i + 1; j < this.dsNhanSu.size(); j++) {
				String[] textI = getDsNhanSu().get(i).getHoTen().split(" ");
				String[] textJ = this.dsNhanSu.get(j).getHoTen().split(" ");
				if (textI[textI.length - 1].compareToIgnoreCase(textJ[textJ.length - 1]) > 0) {
					Collections.swap(this.dsNhanSu, i, j);
				}
			}
		}
		System.out.println("Da Sap Xep Danh Sach Nhan Su Theo Ten");
	}

	public double tinhTongThuNhapGiamDoc(GiamDoc gd, double loiNhuanCongTy) {
		return gd.getTienLuong() + gd.getCoPhanCongTy() * loiNhuanCongTy / 100;
	}

	public double tinhLoiNhuanCongTy() {
		return this.doanhThuThang - tinhTongLuongChoToanBoCongTy();
	}

	public double tinhTongLuongChoToanBoCongTy() {
		double tongLuong = 0;
		for (NhanSu ns : this.dsNhanSu) {
			ns.tinhLuong();
			tongLuong += ns.getTienLuong();
		}
		return tongLuong;
	}

	public void tinhVaXuatTongLuongChoToanBoCongTy() {

		System.out.println("Tong luong cua Cong Ty :" + tinhTongLuongChoToanBoCongTy() + " VNĐ");
	}
	public ArrayList<NhanSu> getArrayListFollowClass(String stringClass){
		stringClass = "class "+stringClass;
		ArrayList<NhanSu> listNhanSu = new ArrayList<NhanSu>();
		for(NhanSu ns : this.dsNhanSu) {
			if(String.valueOf(ns.getClass()).equalsIgnoreCase(stringClass)) {;
			listNhanSu.add(ns);
			}
		}
		
		return listNhanSu;
	}
	public void truongPhongCoSoLuongNhanVienDuoiQuyenNhieuNhat() {
		TruongPhong tpMax =null;
		ArrayList<NhanSu> dsTruongPhong = getArrayListFollowClass("TruongPhong");
		
		ArrayList<NhanSu> dsTruongPhongMax = new ArrayList<NhanSu>();
		if (dsTruongPhong.size()!=0) {
			NhanSu nsTemp = dsTruongPhong.get(0);
			System.out.println(nsTemp.getClass());
			tpMax = ((TruongPhong)nsTemp);
			for (int i = 0; i < dsTruongPhong.size(); i++) {
				TruongPhong tpCurrent = (TruongPhong) dsTruongPhong.get(i);
				if (tpMax.getSoLuongNhanVienDuoiQuyen()<tpCurrent.getSoLuongNhanVienDuoiQuyen()) {
					tpMax = tpCurrent;
				}
			}
			for(NhanSu ns :dsTruongPhong) {
				if(((TruongPhong)ns).getSoLuongNhanVienDuoiQuyen()==tpMax.getSoLuongNhanVienDuoiQuyen()&&((TruongPhong)ns).getSoLuongNhanVienDuoiQuyen()!=0) {
					dsTruongPhongMax.add(ns);
				}
				outputDsNhanSu("Danh Sach Truong Phong Co So Luong Nhan Vien Cao Nhat", dsTruongPhongMax);
			}
		}
		else {
			 System.out.println("Khong ton tai truong phong hoac khong co truong phong nao co nhan vien duoi quyen !");

		}
	}

	public void sapXepNhanSuTheoLuongGiamDan() {
		for (int i = 0; i < this.dsNhanSu.size() - 1; i++) {
			for (int j = i + 1; j < this.dsNhanSu.size(); j++) {
				if (this.dsNhanSu.get(i).getTienLuong() < this.dsNhanSu.get(j).getTienLuong()) {
					Collections.swap(dsNhanSu, i, j);
				}
			}
		}
		System.out.println("Da sap xep giam dan theo luong !");
	}

	public void giamDocCoSoLuongCoPhanNhieuNhat() {
		ArrayList<GiamDoc> listGiamDoc = new ArrayList<GiamDoc>();
		ArrayList<GiamDoc> listGiamDocMax = new ArrayList<GiamDoc>();
		GiamDoc gdMax = null;
		for (int i = 0; i < this.dsNhanSu.size(); i++) {
			if (this.dsNhanSu.get(i) instanceof GiamDoc) {
				listGiamDoc.add(((GiamDoc) this.dsNhanSu.get(i)));
			}
		}
		if (listGiamDoc.size() != 0) {
			gdMax = listGiamDoc.get(0);
			for (GiamDoc giamDoc : listGiamDoc) {
				if (giamDoc.getCoPhanCongTy() > gdMax.getCoPhanCongTy()) {
					gdMax = giamDoc;
				}

			}

			for (GiamDoc giamDoc : listGiamDoc) {
				if (giamDoc.getCoPhanCongTy() == gdMax.getCoPhanCongTy() && giamDoc.getCoPhanCongTy() != 0) {
					listGiamDocMax.add(giamDoc);
				}

			}
		}
		if (listGiamDocMax != null) {
			outputDsGiamDoc("Danh Sach Giam Doc Co Phan Cao Nhat", listGiamDocMax);
		} else
			System.out.println("Khong ton tai giam doc hoac khong co giam doc co co phan nao !");

	}

	public void nhanVienThuongCoLuongCaoNhat() {
		ArrayList<NhanSu> dsNhanVienMax = new ArrayList<NhanSu>();
		ArrayList<NhanSu> dsNhanVien = getArrayListFollowClass("NhanVien");
		NhanSu nvMax = null;
		for (int i = 0; i < this.dsNhanSu.size(); i++) {
			if (this.dsNhanSu.get(i) instanceof NhanVien) {
				dsNhanVien.add(this.dsNhanSu.get(i));

			}
		}
		if (dsNhanVien.size() != 0) {
			nvMax = dsNhanVien.get(0);
			for (int i = 0; i < dsNhanVien.size(); i++) {
				NhanVien nv = (NhanVien) dsNhanVien.get(i);
				if (nv.getSoNgayLamViec() != 0 && nv.getTienLuong() == 0) {
					nv.tinhLuong();
				}
					if (nv.getTienLuong() > ((NhanVien) nvMax).getTienLuong()) {
						nvMax = (NhanVien) nv;
					}
				}

			}
			for (NhanSu ns : dsNhanVien) {
				if (ns.getTienLuong() == nvMax.getTienLuong()) {
					dsNhanVienMax.add(ns);
				}
			}
			if (dsNhanVienMax.size() != 0) {
				outputDsNhanSu("Danh Sach Nhan Vien Co Luong Cao Nhat", dsNhanVienMax);
			}
		 else
			System.out.println("Khong ton tai nhan vien hoac nhan vien co luong bang 0");
	}

	public void phanBoNhanVienVaoTruongPhong() {
		// duyet ds nhan vien, get hoten, ms
		// duyet ds truong phong, lay truong phong theo ms
		// phan bo
		for (NhanSu ns : dsNhanSu) {
			if (ns instanceof NhanVien) {
				System.out.print("Dang duyet nhan vien :");
				System.out.println("Ma So :" + ns.getMaSo() + "\t Ho ten :" + ns.getHoTen());

				int phanBo;
				do {
					System.out.println("Co muon phan bo Truong Phong cho nhan vien nay khong? ");
					System.out.println("0. Khong");
					System.out.println("1. Co ");

					phanBo = Scan.scanInteger();
				} while (phanBo > 1 || phanBo < 0);
				if (phanBo == 1) {
					System.out.println("Danh Sach Truong Phong");
					outputDsTruongPhong();
					TruongPhong tp = null;
					String maTp;
					do {
						System.out.print("Nhap ma Truong Phong (Enter de bo qua) :");
						maTp = Scan.scan.nextLine();
						tp = getTruongPhongTheoMa(maTp);
						if (tp != null || !maTp.isEmpty())
							System.out.println("Ma khong hop le!");
					} while (tp == null && !maTp.isEmpty());
					if (tp != null) {
						NhanVien nv = (NhanVien) ns;
						nv.setTruongPhongQuanLy(tp);
						tp.themMotNhanVienDuoiQuyen();
						System.out.println("Phan bo thanh cong !");
					}
				}
			}
		}
	}

	public void outputDsTruongPhong() {
		for (NhanSu ns : this.dsNhanSu) {
			if (ns instanceof TruongPhong) {
				System.out.println("Ma So :" + ns.getMaSo() + "\t Ho ten :" + ns.getHoTen());
			}
		}
	}

	public void xoaNhanSuTheoMa() {
		System.out.println("***** Xoa Nhan Su *****");
		NhanSu ns = null;
		String maNS;
		do {
			System.out.print("Nhap ma nhan su can xoa :");
			maNS = Scan.scan.nextLine();
			ns = getNhanSuTheoMa(maNS);
			if (ns == null)
				System.out.println("Ma khong hop le !");
		} while (ns == null);
		// xóa nhân sự
		xoaNhanSu(ns);

	}

	public void xoaNhanSu(NhanSu ns) {
		if (ns instanceof GiamDoc) {
//			// cách ruom ra
//			for(NhanSu nhansu : this.dsNhanSu) {
//				if(ns.getMaSo().equals(ns.getMaSo())) {
//					dsNhanSu.remove(nhansu);
//				}
//			}
			// cách nhanh hơn
			this.dsNhanSu.remove(ns);
			System.out.println("Xoa thanh cong!");
		} else if (ns instanceof NhanVien) {
			// xóa ns theo nhan vien
			// giảm đi 1 nhan su neu nhan vien do co truong phong quan li
			NhanVien nv = (NhanVien) ns;
			if (nv.getTruongPhongQuanLy() != null) {
				nv.getTruongPhongQuanLy().xoaMotNhanVienDuoiQuyen();
			}
			this.dsNhanSu.remove(ns);
			System.out.println("Xoa thanh cong!");

		} else {
			TruongPhong tp = (TruongPhong) ns;
			xoaLienKetNhanVienVaTruongPhongTheoMaTP(tp.getMaSo());
			dsNhanSu.remove(tp);
			System.out.println("Xoa thanh cong!");
		}
	}

	public void xoaLienKetNhanVienVaTruongPhongTheoMaTP(String maTP) {
		for (NhanSu ns : this.dsNhanSu) {
			if (ns instanceof NhanVien) {
				NhanVien nv = (NhanVien) ns;
				if (nv.getTruongPhongQuanLy() != null) {
					if (nv.getTruongPhongQuanLy().getMaSo().equals(maTP)) {
						nv.setTruongPhongQuanLy(null);
					}

				}
			}
		}
	}

	public NhanSu getNhanSuTheoMa(String maNS) {
		NhanSu nsReturn = null;
		for (NhanSu ns : this.dsNhanSu) {
			if (ns.getMaSo().equalsIgnoreCase(maNS)) {
				nsReturn = ns;
			}
		}
		return nsReturn;
	}

	public TruongPhong getTruongPhongTheoMa(String maTP) {
		TruongPhong tp = null;

		for (NhanSu ns : this.dsNhanSu) {
			if (ns instanceof TruongPhong) {
				if (ns.getMaSo().equalsIgnoreCase(maTP)) {
					tp = (TruongPhong) ns;
				}
			}
		}
		return tp;
	}

	// read - write file
	public void outputFile(String fileName) {
		if (fileName.isEmpty())
			fileName = "DanhSachNhanSu.dat";
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(this.dsNhanSu);
			oos.writeObject(tenCongTy);
			oos.writeObject(maSoThue);
			oos.writeObject(doanhThuThang);
			System.out.println("Luu file thanh cong !");
			oos.close();
			fos.close();
		} catch (Exception e) {
			System.out.println("Loi luu file !");
		}
	}

	public void inputFile(String fileName) {
		if (fileName.isEmpty())
			fileName = "DanhSachNhanSu.dat";
		try {
			FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis);
			this.dsNhanSu = (ArrayList<NhanSu>) ois.readObject();
			this.tenCongTy = (String) ois.readObject();
			this.maSoThue = (String) ois.readObject();
			this.doanhThuThang = (double) ois.readObject();
			System.out.println("Doc file thanh cong!");
			ois.close();
			fis.close();
		} catch (Exception e) {
			System.out.println("Loi doc file!");
		}
	}

}
