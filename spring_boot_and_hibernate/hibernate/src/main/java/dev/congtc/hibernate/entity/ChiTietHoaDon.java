package dev.congtc.hibernate.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "chi_tiet_hoa_don")
public class ChiTietHoaDon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_chi_tiet")
    private Integer idChiTiet;

    @Column(name = "so_luong", nullable = false)
    private Integer soLuong;

    @Column(name = "gia_ban", nullable = false)
    private Double giaBan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_hoa_don")
    private HoaDon hoaDon;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_san_pham")
    private SanPham sanPham;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(Integer idChiTiet, Integer soLuong, Double giaBan, HoaDon hoaDon, SanPham sanPham) {
        this.idChiTiet = idChiTiet;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
        this.hoaDon = hoaDon;
        this.sanPham = sanPham;
    }

    public Integer getIdChiTiet() {
        return idChiTiet;
    }

    public void setIdChiTiet(Integer idChiTiet) {
        this.idChiTiet = idChiTiet;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Double giaBan) {
        this.giaBan = giaBan;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    @Override
    public String toString() {
        return "ChiTietHoaDon{" +
                "idChiTiet=" + idChiTiet +
                ", soLuong=" + soLuong +
                ", giaBan=" + giaBan +
                ", hoaDon=" + hoaDon +
                ", sanPham=" + sanPham +
                '}';
    }
}
