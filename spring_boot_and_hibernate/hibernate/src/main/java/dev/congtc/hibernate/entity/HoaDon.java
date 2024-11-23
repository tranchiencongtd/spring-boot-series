package dev.congtc.hibernate.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "hoa_don")
public class HoaDon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hoa_don")
    private Integer idHoaDon;

    @Column(name = "ngay_lap", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date ngayLap;

    @Column(name = "tong_tien")
    private Double tongTien;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User user;

    @OneToMany(mappedBy = "hoaDon", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChiTietHoaDon> chiTietHoaDons;

    public HoaDon() {
    }

    public HoaDon(Integer idHoaDon, Date ngayLap, Double tongTien, User user, List<ChiTietHoaDon> chiTietHoaDons) {
        this.idHoaDon = idHoaDon;
        this.ngayLap = ngayLap;
        this.tongTien = tongTien;
        this.user = user;
        this.chiTietHoaDons = chiTietHoaDons;
    }

    public Integer getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(Integer idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

    public Double getTongTien() {
        return tongTien;
    }

    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ChiTietHoaDon> getChiTietHoaDons() {
        return chiTietHoaDons;
    }

    public void setChiTietHoaDons(List<ChiTietHoaDon> chiTietHoaDons) {
        this.chiTietHoaDons = chiTietHoaDons;
    }

    @Override
    public String toString() {
        return "HoaDon{" +
                "idHoaDon=" + idHoaDon +
                ", ngayLap=" + ngayLap +
                ", tongTien=" + tongTien +
                ", user=" + user +
                ", chiTietHoaDons=" + chiTietHoaDons +
                '}';
    }
}
