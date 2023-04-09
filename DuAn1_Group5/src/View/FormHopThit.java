/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import ViewModels.HopThitView;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import Service.Implement.HopThitServices;
import Service.Implement.LoaiThitService;
import Service.Implement.NCCServices;
import Service.Implement.ThitService;
import Service.Implement.XuatXuService;
import ViewModels.LoaiThitView;
import ViewModels.NhaCCView;
import ViewModels.ThitView;
import ViewModels.XuatXuView;
import java.awt.Frame;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;


public class FormHopThit extends javax.swing.JFrame {

    JButton myButton = new JButton();
    HopThitView htv = new HopThitView();
    private HopThitServices service = new HopThitServices();
    private ThitService thitService = new ThitService();
    private  LoaiThitService loaiThitService = new LoaiThitService();
    private  XuatXuService xuatXuService = new XuatXuService();
    private  NCCServices nCCServices = new NCCServices();
    private CardLayout cardLayout;

    /**
     * Creates new form Home20
     */
    public FormHopThit() {
        initComponents();
        this.setLocationRelativeTo(null);
        cardLayout = (CardLayout) pnlRight.getLayout();

        if (OSUtils.getOSType() == OSUtils.OSType.MacOS) {
            pnlTop.remove(pnlTitle);
            pnlTop.remove(pnlRight);

            pnlTop.add(pnlTitle, BorderLayout.EAST);
            pnlTop.add(pnlActions, BorderLayout.WEST);

            pnlActions.remove(lblClose);
            pnlActions.remove(lblMaximize);
            pnlActions.remove(lblMinimize);

            pnlActions.add(lblClose);
            pnlActions.add(lblMaximize);
            pnlActions.add(lblMinimize);

            pnlTitle.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 8));

        }
        if (OSUtils.getOSType() == OSUtils.OSType.Windows) {
            pnlTop.remove(pnlTitle);
            pnlTop.remove(pnlRight);

            pnlTop.add(pnlTitle, BorderLayout.WEST);
            pnlTop.add(pnlActions, BorderLayout.EAST);

            pnlActions.remove(lblClose);
            pnlActions.remove(lblMaximize);
            pnlActions.remove(lblMinimize);

            pnlActions.add(lblMinimize);
            pnlActions.add(lblMaximize);
            pnlActions.add(lblClose);

            pnlTitle.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 8));

        }
        this.taiDuLieu();
        taiDuLieuThit();
        taiDuLieuLoaiThit();
        taiDuLieuXuatXu();
        taiDuLieuNhaCungCap();

        ImageIcon icon = new ImageIcon("images/add.png");
        myButton.setIcon(icon);
        add(myButton);
    }
     private void taiDuLieuThit() {
        List<ThitView> list = thitService.getAll();
        for (ThitView thitView : list) {
            cboThit.addItem(thitView.getTen());
        }
    }

    private void taiDuLieuLoaiThit() {
        List<LoaiThitView> list = loaiThitService.getAll();
        for (LoaiThitView item : list) {
            cboLoaiThit.addItem(item.getId());
        }
    }

    private void taiDuLieuXuatXu() {
        List<XuatXuView> list = xuatXuService.getAll();
        for (XuatXuView item : list) {
            cboXuatXu.addItem(item.getId());
        }
    }

    private void taiDuLieuNhaCungCap() {
        List<NhaCCView> list = nCCServices.getAll();
        for (NhaCCView item : list) {
            cboNCC.addItem(item.getId());
        }
    }

   private void taiDuLieu() {
        DefaultTableModel model = (DefaultTableModel) this.tblHopThit.getModel();
        model.setRowCount(0);
        ArrayList<HopThitView> list = (ArrayList<HopThitView>) this.service.getal();
        System.err.println(list.size());
        for (HopThitView x : list) {
            Object[] rowData = {
                x.getId(),
                x.getMa(),
                x.getTenHopThit(),
                x.getIdThit(),
                x.getIdLoaiThit(),
                x.getGiaNhap(),
                x.getGiaBan(),
                x.getSoLuongTon(),
                x.getNgayDongGoi(),
                x.getHSD(),
                x.getMoTa(),
                x.getTrangThai(),
                x.getIdXuatXu(),
                x.getIdNCC()
            };
            model.addRow(rowData);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTop = new javax.swing.JPanel();
        pnlActions = new javax.swing.JPanel();
        lblMinimize = new javax.swing.JLabel();
        lblMaximize = new javax.swing.JLabel();
        lblClose = new javax.swing.JLabel();
        pnlTitle = new javax.swing.JPanel();
        pnlParent = new javax.swing.JPanel();
        sidepane = new javax.swing.JPanel();
        btn_banHang = new javax.swing.JPanel();
        ind_typo = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_hoaDon = new javax.swing.JPanel();
        ind_fonts = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btn_nhanVien = new javax.swing.JPanel();
        ind_icons = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btn_thongKe = new javax.swing.JPanel();
        ind_btns = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btn_hopThit = new javax.swing.JPanel();
        ind_data = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        btn_giamGia = new javax.swing.JPanel();
        ind_giamGia = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        btn_khachHang = new javax.swing.JPanel();
        ind_khachHang = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        pnlRight = new javax.swing.JPanel();
        pnlDataCards = new javax.swing.JPanel();
        pnlDataCards1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHopThit = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnAnh = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        LBID = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        rdoConHang = new javax.swing.JRadioButton();
        rdoHetHang = new javax.swing.JRadioButton();
        cboThit = new javax.swing.JComboBox();
        cboLoaiThit = new javax.swing.JComboBox();
        cboNCC = new javax.swing.JComboBox();
        btnaddThit = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        cboXuatXu = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        txtGiaNhap = new javax.swing.JTextField();
        txtGiaBan = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        txtHSD = new javax.swing.JTextField();
        txtNgayDongGoi = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        jLabel27 = new javax.swing.JLabel();
        pnlTypography = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Title Frame Test");
        setLocationByPlatform(true);
        setUndecorated(true);

        pnlTop.setBackground(new java.awt.Color(255, 51, 51));
        pnlTop.setPreferredSize(new java.awt.Dimension(1024, 30));
        pnlTop.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlTopMouseDragged(evt);
            }
        });
        pnlTop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlTopMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlTopMousePressed(evt);
            }
        });
        pnlTop.setLayout(new java.awt.BorderLayout());

        pnlActions.setBackground(new java.awt.Color(255, 51, 51));
        pnlActions.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        lblMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_minus_18px_1.png"))); // NOI18N
        lblMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblMinimizeMousePressed(evt);
            }
        });
        pnlActions.add(lblMinimize);

        lblMaximize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_rectangle_stroked_18px.png"))); // NOI18N
        lblMaximize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblMaximizeMousePressed(evt);
            }
        });
        pnlActions.add(lblMaximize);

        lblClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_multiply_18px_1.png"))); // NOI18N
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblCloseMousePressed(evt);
            }
        });
        pnlActions.add(lblClose);

        pnlTop.add(pnlActions, java.awt.BorderLayout.LINE_END);

        pnlTitle.setBackground(new java.awt.Color(255, 51, 51));
        pnlTitle.setPreferredSize(new java.awt.Dimension(200, 30));
        pnlTitle.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 8));
        pnlTop.add(pnlTitle, java.awt.BorderLayout.LINE_START);

        getContentPane().add(pnlTop, java.awt.BorderLayout.PAGE_START);

        pnlParent.setLayout(new java.awt.BorderLayout());

        sidepane.setBackground(new java.awt.Color(255, 51, 51));
        sidepane.setForeground(new java.awt.Color(51, 51, 51));
        sidepane.setPreferredSize(new java.awt.Dimension(250, 200));
        sidepane.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                sidepaneMouseDragged(evt);
            }
        });
        sidepane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sidepaneMousePressed(evt);
            }
        });

        btn_banHang.setBackground(new java.awt.Color(255, 51, 51));
        btn_banHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_banHangMousePressed(evt);
            }
        });
        btn_banHang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ind_typo.setOpaque(false);
        ind_typo.setPreferredSize(new java.awt.Dimension(4, 40));

        javax.swing.GroupLayout ind_typoLayout = new javax.swing.GroupLayout(ind_typo);
        ind_typo.setLayout(ind_typoLayout);
        ind_typoLayout.setHorizontalGroup(
            ind_typoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );
        ind_typoLayout.setVerticalGroup(
            ind_typoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        btn_banHang.add(ind_typo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setText("Thanh toán");
        btn_banHang.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MeatPoly");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Thịt sạch");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("V1.0.0");

        btn_hoaDon.setBackground(new java.awt.Color(255, 51, 51));
        btn_hoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_hoaDonMousePressed(evt);
            }
        });
        btn_hoaDon.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ind_fonts.setOpaque(false);
        ind_fonts.setPreferredSize(new java.awt.Dimension(4, 40));

        javax.swing.GroupLayout ind_fontsLayout = new javax.swing.GroupLayout(ind_fonts);
        ind_fonts.setLayout(ind_fontsLayout);
        ind_fontsLayout.setHorizontalGroup(
            ind_fontsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );
        ind_fontsLayout.setVerticalGroup(
            ind_fontsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        btn_hoaDon.add(ind_fonts, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Hóa đơn");
        btn_hoaDon.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        btn_nhanVien.setBackground(new java.awt.Color(255, 51, 51));
        btn_nhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_nhanVienMousePressed(evt);
            }
        });
        btn_nhanVien.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ind_icons.setOpaque(false);
        ind_icons.setPreferredSize(new java.awt.Dimension(4, 40));

        javax.swing.GroupLayout ind_iconsLayout = new javax.swing.GroupLayout(ind_icons);
        ind_icons.setLayout(ind_iconsLayout);
        ind_iconsLayout.setHorizontalGroup(
            ind_iconsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );
        ind_iconsLayout.setVerticalGroup(
            ind_iconsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        btn_nhanVien.add(ind_icons, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Quản lý nhân viên");
        btn_nhanVien.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setText("Functions");

        btn_thongKe.setBackground(new java.awt.Color(255, 51, 51));
        btn_thongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_thongKeMousePressed(evt);
            }
        });
        btn_thongKe.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ind_btns.setOpaque(false);
        ind_btns.setPreferredSize(new java.awt.Dimension(4, 40));

        javax.swing.GroupLayout ind_btnsLayout = new javax.swing.GroupLayout(ind_btns);
        ind_btns.setLayout(ind_btnsLayout);
        ind_btnsLayout.setHorizontalGroup(
            ind_btnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );
        ind_btnsLayout.setVerticalGroup(
            ind_btnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        btn_thongKe.add(ind_btns, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setText("Thống kê");
        btn_thongKe.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        btn_hopThit.setBackground(new java.awt.Color(255, 51, 51));
        btn_hopThit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_hopThitMousePressed(evt);
            }
        });
        btn_hopThit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ind_data.setOpaque(false);
        ind_data.setPreferredSize(new java.awt.Dimension(4, 40));

        javax.swing.GroupLayout ind_dataLayout = new javax.swing.GroupLayout(ind_data);
        ind_data.setLayout(ind_dataLayout);
        ind_dataLayout.setHorizontalGroup(
            ind_dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );
        ind_dataLayout.setVerticalGroup(
            ind_dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        btn_hopThit.add(ind_data, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setText("Quản lý hộp thịt");
        btn_hopThit.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        btn_giamGia.setBackground(new java.awt.Color(255, 51, 51));
        btn_giamGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_giamGiaMousePressed(evt);
            }
        });
        btn_giamGia.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ind_giamGia.setOpaque(false);
        ind_giamGia.setPreferredSize(new java.awt.Dimension(4, 40));

        javax.swing.GroupLayout ind_giamGiaLayout = new javax.swing.GroupLayout(ind_giamGia);
        ind_giamGia.setLayout(ind_giamGiaLayout);
        ind_giamGiaLayout.setHorizontalGroup(
            ind_giamGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );
        ind_giamGiaLayout.setVerticalGroup(
            ind_giamGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        btn_giamGia.add(ind_giamGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("Giảm giá");
        btn_giamGia.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        btn_khachHang.setBackground(new java.awt.Color(255, 51, 51));
        btn_khachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_khachHangMousePressed(evt);
            }
        });
        btn_khachHang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ind_khachHang.setOpaque(false);
        ind_khachHang.setPreferredSize(new java.awt.Dimension(4, 40));

        javax.swing.GroupLayout ind_khachHangLayout = new javax.swing.GroupLayout(ind_khachHang);
        ind_khachHang.setLayout(ind_khachHangLayout);
        ind_khachHangLayout.setHorizontalGroup(
            ind_khachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );
        ind_khachHangLayout.setVerticalGroup(
            ind_khachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        btn_khachHang.add(ind_khachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 204, 204));
        jLabel13.setText("Khách hàng");
        btn_khachHang.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        javax.swing.GroupLayout sidepaneLayout = new javax.swing.GroupLayout(sidepane);
        sidepane.setLayout(sidepaneLayout);
        sidepaneLayout.setHorizontalGroup(
            sidepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_banHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_hoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_nhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_thongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_hopThit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(sidepaneLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(sidepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(sidepaneLayout.createSequentialGroup()
                        .addGroup(sidepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)))
                .addContainerGap(43, Short.MAX_VALUE))
            .addComponent(btn_giamGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_khachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        sidepaneLayout.setVerticalGroup(
            sidepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidepaneLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(sidepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(41, 41, 41)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_banHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_hoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_nhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_thongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_hopThit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_giamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_khachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(372, Short.MAX_VALUE))
        );

        pnlParent.add(sidepane, java.awt.BorderLayout.LINE_START);

        pnlRight.setLayout(new java.awt.CardLayout());

        tblHopThit.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Mã", "Tên", "Thịt", "Loại Thịt", "Giá Nhập", "Giá Bán", "Số Lượng", "Ngày Đóng Gói", "HSD", "Mô Tả", "Trạng Thái", "Xuất Xứ", "Nhà Cung Cấp"
            }
        ));
        tblHopThit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHopThitMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHopThit);

        jLabel4.setText("DANH SÁCH SẢN PHẨM");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnThem.setText("Thêm");
        btnThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemMouseClicked(evt);
            }
        });
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnAnh.setLabel("Ảnh");
        btnAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAnhMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                    .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel8.setText("ID:");

        jLabel14.setText("Mã:");

        jLabel16.setText("Trạng Thái:");

        jLabel17.setText("Thịt:");

        jLabel18.setText("Loại Thịt:");

        jLabel19.setText("Nhà Cung Cấp:");

        LBID.setText("---");

        rdoConHang.setText("Còn Hàng");

        rdoHetHang.setText("Hết Hàng");

        btnaddThit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddThitActionPerformed(evt);
            }
        });

        jLabel26.setText("Xuất Xứ:");

        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboNCC, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(26, 26, 26)
                                .addComponent(cboThit, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnaddThit, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdoConHang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdoHetHang))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel8))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LBID)
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboXuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboLoaiThit, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap(321, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(LBID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(rdoConHang)
                    .addComponent(rdoHetHang))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(cboThit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnaddThit, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(cboLoaiThit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel26)
                                .addComponent(cboXuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel19)
                                .addComponent(cboNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel15.setText("Tên:");

        jLabel20.setText("Giá Nhập:");

        jLabel22.setText("Số Lượng:");

        jLabel21.setText("Giá Bán:");

        jLabel23.setText("Ngày Đóng Gói:");

        jLabel24.setText("HSD:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23)
                            .addComponent(jLabel24))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHSD)
                            .addComponent(txtSoLuong)
                            .addComponent(txtNgayDongGoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21)
                            .addComponent(jLabel15))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtGiaNhap)
                                    .addComponent(txtGiaBan)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 205, Short.MAX_VALUE)
                                .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(40, 40, 40))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel23)
                    .addComponent(txtNgayDongGoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txtHSD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel25.setText("Mô Tả");

        txtMoTa.setColumns(20);
        txtMoTa.setRows(5);
        jScrollPane2.setViewportView(txtMoTa);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel25)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel25)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlDataCards1Layout = new javax.swing.GroupLayout(pnlDataCards1);
        pnlDataCards1.setLayout(pnlDataCards1Layout);
        pnlDataCards1Layout.setHorizontalGroup(
            pnlDataCards1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDataCards1Layout.createSequentialGroup()
                .addGap(441, 441, 441)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlDataCards1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDataCards1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(pnlDataCards1Layout.createSequentialGroup()
                        .addGroup(pnlDataCards1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDataCards1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(pnlDataCards1Layout.createSequentialGroup()
                                .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(238, 238, 238)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        pnlDataCards1Layout.setVerticalGroup(
            pnlDataCards1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDataCards1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDataCards1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDataCards1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlDataCardsLayout = new javax.swing.GroupLayout(pnlDataCards);
        pnlDataCards.setLayout(pnlDataCardsLayout);
        pnlDataCardsLayout.setHorizontalGroup(
            pnlDataCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDataCardsLayout.createSequentialGroup()
                .addComponent(pnlDataCards1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
        );
        pnlDataCardsLayout.setVerticalGroup(
            pnlDataCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDataCardsLayout.createSequentialGroup()
                .addComponent(pnlDataCards1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlRight.add(pnlDataCards, "card1");

        javax.swing.GroupLayout pnlTypographyLayout = new javax.swing.GroupLayout(pnlTypography);
        pnlTypography.setLayout(pnlTypographyLayout);
        pnlTypographyLayout.setHorizontalGroup(
            pnlTypographyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1238, Short.MAX_VALUE)
        );
        pnlTypographyLayout.setVerticalGroup(
            pnlTypographyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 853, Short.MAX_VALUE)
        );

        pnlRight.add(pnlTypography, "card2");

        pnlParent.add(pnlRight, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlParent, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    int xy, xx;
    private void sidepaneMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sidepaneMouseDragged
        // TODO add your handling code here:

    }//GEN-LAST:event_sidepaneMouseDragged

    private void sidepaneMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sidepaneMousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_sidepaneMousePressed

    private void btn_banHangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_banHangMousePressed
        // TODO add your handling code here:

        setColor(btn_banHang);
        resetColor(btn_hopThit);
        resetColor(btn_thongKe);
        resetColor(btn_hoaDon);
        resetColor(btn_nhanVien);
        resetColor(btn_giamGia);
        resetColor(btn_khachHang);
        ind_typo.setOpaque(true);
        ind_btns.setOpaque(false);
        ind_data.setOpaque(false);
        ind_fonts.setOpaque(false);
        ind_icons.setOpaque(false);
        ind_giamGia.setOpaque(false);
        ind_khachHang.setOpaque(false);

//        cardLayout.show(pnlRight, "card2");
        Home homeForAd = new Home();
        homeForAd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_banHangMousePressed

    private void btn_hoaDonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hoaDonMousePressed
        // TODO add your handling code here:
        setColor(btn_hoaDon);
        resetColor(btn_hopThit);
        resetColor(btn_thongKe);
        resetColor(btn_banHang);
        resetColor(btn_nhanVien);
        resetColor(btn_giamGia);
        resetColor(btn_khachHang);
        //indicators
        ind_typo.setOpaque(false);
        ind_btns.setOpaque(false);
        ind_data.setOpaque(false);
        ind_fonts.setOpaque(true);
        ind_icons.setOpaque(false);
        ind_giamGia.setOpaque(false);
        ind_khachHang.setOpaque(false);

        FormHoaDon hd = new FormHoaDon();
        hd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_hoaDonMousePressed

    private void btn_nhanVienMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nhanVienMousePressed
        // TODO add your handling code here:
        setColor(btn_nhanVien);
        resetColor(btn_hopThit);
        resetColor(btn_thongKe);
        resetColor(btn_hoaDon);
        resetColor(btn_banHang);
        resetColor(btn_giamGia);
        resetColor(btn_khachHang);

        ind_typo.setOpaque(false);
        ind_btns.setOpaque(false);
        ind_data.setOpaque(false);
        ind_fonts.setOpaque(false);
        ind_icons.setOpaque(true);
        ind_giamGia.setOpaque(false);
        ind_khachHang.setOpaque(false);

        FormNhanVien nv = new FormNhanVien();
        nv.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_nhanVienMousePressed

    private void btn_thongKeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_thongKeMousePressed
        // TODO add your handling code here:
        setColor(btn_thongKe);
        resetColor(btn_hopThit);
        resetColor(btn_banHang);
        resetColor(btn_hoaDon);
        resetColor(btn_nhanVien);
        resetColor(btn_giamGia);
        resetColor(btn_khachHang);

        ind_typo.setOpaque(false);
        ind_btns.setOpaque(true);
        ind_data.setOpaque(false);
        ind_fonts.setOpaque(false);
        ind_icons.setOpaque(false);
        ind_giamGia.setOpaque(false);
        ind_khachHang.setOpaque(false);

        FormThongKe tk = new FormThongKe();
        tk.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_thongKeMousePressed

    private void btn_hopThitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hopThitMousePressed
        // TODO add your handling code here:
        setColor(btn_hopThit);
        resetColor(btn_banHang);
        resetColor(btn_thongKe);
        resetColor(btn_hoaDon);
        resetColor(btn_nhanVien);
        resetColor(btn_giamGia);
        resetColor(btn_khachHang);

        ind_typo.setOpaque(false);
        ind_btns.setOpaque(false);
        ind_data.setOpaque(true);
        ind_fonts.setOpaque(false);
        ind_icons.setOpaque(false);
        ind_giamGia.setOpaque(false);
        ind_khachHang.setOpaque(false);

//        cardLayout.show(pnlRight, "card1");
        FormHopThit ht = new FormHopThit();
        ht.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_hopThitMousePressed


    private void lblMaximizeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMaximizeMousePressed
        if (FormHopThit.this.getExtendedState() == MAXIMIZED_BOTH) {
            FormHopThit.this.setExtendedState(JFrame.NORMAL);
        } else {
            FormHopThit.this.setExtendedState(MAXIMIZED_BOTH);
        }
    }//GEN-LAST:event_lblMaximizeMousePressed

    private void lblCloseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMousePressed
        System.exit(0);
    }//GEN-LAST:event_lblCloseMousePressed

    private void lblMinimizeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizeMousePressed
        FormHopThit.this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_lblMinimizeMousePressed

    private void pnlTopMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlTopMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_pnlTopMousePressed

    private void pnlTopMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlTopMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_pnlTopMouseDragged

    private void pnlTopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlTopMouseClicked
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            if (FormHopThit.this.getExtendedState() == MAXIMIZED_BOTH) {
                FormHopThit.this.setExtendedState(JFrame.NORMAL);
            } else {
                FormHopThit.this.setExtendedState(MAXIMIZED_BOTH);
            }
        }
    }//GEN-LAST:event_pnlTopMouseClicked

    private void btn_giamGiaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_giamGiaMousePressed
        // TODO add your handling code here:
        setColor(btn_giamGia);
        resetColor(btn_banHang);
        resetColor(btn_thongKe);
        resetColor(btn_hoaDon);
        resetColor(btn_nhanVien);
        resetColor(btn_hopThit);
        resetColor(btn_khachHang);

        ind_typo.setOpaque(false);
        ind_btns.setOpaque(false);
        ind_data.setOpaque(false);
        ind_fonts.setOpaque(false);
        ind_icons.setOpaque(false);
        ind_giamGia.setOpaque(true);
        ind_khachHang.setOpaque(false);

        FormGiamGia gg = new FormGiamGia();
        gg.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_giamGiaMousePressed

    private void btn_khachHangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_khachHangMousePressed
        // TODO add your handling code here:
        setColor(btn_khachHang);
        resetColor(btn_banHang);
        resetColor(btn_thongKe);
        resetColor(btn_hoaDon);
        resetColor(btn_nhanVien);
        resetColor(btn_giamGia);
        resetColor(btn_hopThit);

        ind_typo.setOpaque(false);
        ind_btns.setOpaque(false);
        ind_data.setOpaque(false);
        ind_fonts.setOpaque(false);
        ind_icons.setOpaque(false);
        ind_giamGia.setOpaque(false);
        ind_khachHang.setOpaque(true);

        FormKhachHang kH = new FormKhachHang();
        kH.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_khachHangMousePressed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnaddThitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddThitActionPerformed

    }//GEN-LAST:event_btnaddThitActionPerformed

    private void tblHopThitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHopThitMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) this.tblHopThit.getModel();
        int row = tblHopThit.getSelectedRow();
        String id = (String) model.getValueAt(row, 0);
        String ma = (String) model.getValueAt(row, 1);
        String ten = (String) model.getValueAt(row, 2);
        String thit = (String) model.getValueAt(row, 3);
        String loaiThit = (String) model.getValueAt(row, 4);
        double giaNhap = (double) model.getValueAt(row, 5);
        double giaBan = (double) model.getValueAt(row, 6);
        int soLuong = (int) model.getValueAt(row, 7);
        Date ngayDongGoi = (Date) model.getValueAt(row, 8);
        int hsd = (int) model.getValueAt(row, 9);
        String moTa = (String) model.getValueAt(row, 10);
        int trangThai = (int) model.getValueAt(row, 11);
        String xuatXu = (String) model.getValueAt(row, 12);
        String nhaCupCap = (String) model.getValueAt(row, 13);

        LBID.setText(id);
        txtMa.setText(ma);
        txtTen.setText(ten);
        txtGiaBan.setText(Double.toString(giaBan));
        txtGiaNhap.setText(Double.toString(giaNhap));
        txtSoLuong.setText(soLuong + "");
        txtHSD.setText(hsd + "");
        java.util.Date utilDate = new java.util.Date(ngayDongGoi.getTime());
        txtNgayDongGoi.setDate(utilDate);
        txtMoTa.setText(moTa);

        cboThit.setSelectedItem(thit);
        cboLoaiThit.setSelectedItem(loaiThit);
        cboXuatXu.setSelectedItem(xuatXu);
        cboNCC.setSelectedItem(nhaCupCap);

        if (trangThai > 0) {
            rdoConHang.setSelected(true);
        } else {
            rdoHetHang.setSelected(false);
        }

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/" + ma + ".jpg")));
    }//GEN-LAST:event_tblHopThitMouseClicked

    private void btnThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseClicked
        // TODO add your handling code here:
        String ma = txtMa.getText();
        int trangThai = rdoConHang.isSelected() ? 1 : 0;
        String tenThit = (String) cboThit.getSelectedItem();
        String loaiThit = (String) cboThit.getSelectedItem();
        String xuatXu = (String) cboThit.getSelectedItem();
        String ncc = (String) cboThit.getSelectedItem();
        String ten = txtTen.getText();
        double giaNhap = Double.parseDouble(txtGiaNhap.getText());
        double giaBan = Double.parseDouble(txtGiaBan.getText());
        int soLuong = Integer.parseInt(txtSoLuong.getText());
        java.util.Date ngayDongGoi = txtNgayDongGoi.getDate();
        int hsd = Integer.parseInt(txtHSD.getText());
        String moTa = txtMoTa.getText();

        //        ThitView thitView = thitService.getByName(tenThit);
        //        HopThitView hopThitView = new HopThitView(null, ma, ten, giaNhap, giaBan, soLuong, ngayDongGoi, hsd, moTa, trangThai, thitView.getId(), loaiThit, xuatXu, ncc);
        //        if (service.add(hopThitView)) {
            //            taiDuLieu();
            //        }
    }//GEN-LAST:event_btnThemMouseClicked

    private void btnAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnhMouseClicked
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setFileFilter(new FileNameExtensionFilter("JPEG files", "jpg"));

        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            Path source = Paths.get(path);
            String out = "src\\images\\" + txtMa.getText() + ".jpg";
            Path destination = Paths.get(out);

            try {
                Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
                jLabel27.setIcon(new javax.swing.ImageIcon(out));
            } catch (IOException e) {
                System.err.println("Error copying file: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnAnhMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    // set and reset color
    void setColor(JPanel panel) {
        panel.setBackground(new Color(255, 51, 51));
    }

    void resetColor(JPanel panel) {
        panel.setBackground(new Color(255, 102, 102));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormHopThit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormHopThit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormHopThit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormHopThit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormHopThit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LBID;
    private javax.swing.JButton btnAnh;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JPanel btn_banHang;
    private javax.swing.JPanel btn_giamGia;
    private javax.swing.JPanel btn_hoaDon;
    private javax.swing.JPanel btn_hopThit;
    private javax.swing.JPanel btn_khachHang;
    private javax.swing.JPanel btn_nhanVien;
    private javax.swing.JPanel btn_thongKe;
    private javax.swing.JButton btnaddThit;
    private javax.swing.JComboBox cboLoaiThit;
    private javax.swing.JComboBox cboNCC;
    private javax.swing.JComboBox cboThit;
    private javax.swing.JComboBox cboXuatXu;
    private javax.swing.JPanel ind_btns;
    private javax.swing.JPanel ind_data;
    private javax.swing.JPanel ind_fonts;
    private javax.swing.JPanel ind_giamGia;
    private javax.swing.JPanel ind_icons;
    private javax.swing.JPanel ind_khachHang;
    private javax.swing.JPanel ind_typo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblMaximize;
    private javax.swing.JLabel lblMinimize;
    private javax.swing.JPanel pnlActions;
    private javax.swing.JPanel pnlDataCards;
    private javax.swing.JPanel pnlDataCards1;
    private javax.swing.JPanel pnlParent;
    private javax.swing.JPanel pnlRight;
    private javax.swing.JPanel pnlTitle;
    private javax.swing.JPanel pnlTop;
    private javax.swing.JPanel pnlTypography;
    private javax.swing.JRadioButton rdoConHang;
    private javax.swing.JRadioButton rdoHetHang;
    private javax.swing.JPanel sidepane;
    private javax.swing.JTable tblHopThit;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextField txtHSD;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextArea txtMoTa;
    private com.toedter.calendar.JDateChooser txtNgayDongGoi;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}
