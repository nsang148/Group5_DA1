/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import controller.QuanLyThongKeController;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Frame;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author proxc
 */
public class FormThongKe extends javax.swing.JFrame {

    private CardLayout cardLayout;

    /**
     * Creates new form Home20
     */
    public FormThongKe() {
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

            QuanLyThongKeController controller = new QuanLyThongKeController();
            controller.setTienTochart(JpnTK);
            controller.setSPTochart(JpnSp);
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
        pnlRight = new javax.swing.JPanel();
        pnlDataCards = new javax.swing.JPanel();
        JpnTK = new javax.swing.JPanel();
        JpnSp = new javax.swing.JPanel();
        pnlTypography = new javax.swing.JPanel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Title Frame Test");
        setLocationByPlatform(true);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1232, 644));

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

        pnlRight.setLayout(new java.awt.CardLayout());

        pnlDataCards.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        JpnTK.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout JpnTKLayout = new javax.swing.GroupLayout(JpnTK);
        JpnTK.setLayout(JpnTKLayout);
        JpnTKLayout.setHorizontalGroup(
            JpnTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 957, Short.MAX_VALUE)
        );
        JpnTKLayout.setVerticalGroup(
            JpnTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 285, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout JpnSpLayout = new javax.swing.GroupLayout(JpnSp);
        JpnSp.setLayout(JpnSpLayout);
        JpnSpLayout.setHorizontalGroup(
            JpnSpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        JpnSpLayout.setVerticalGroup(
            JpnSpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 285, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlDataCardsLayout = new javax.swing.GroupLayout(pnlDataCards);
        pnlDataCards.setLayout(pnlDataCardsLayout);
        pnlDataCardsLayout.setHorizontalGroup(
            pnlDataCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDataCardsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDataCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JpnSp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JpnTK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlDataCardsLayout.setVerticalGroup(
            pnlDataCardsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDataCardsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JpnTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(JpnSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlRight.add(pnlDataCards, "card1");

        javax.swing.GroupLayout pnlTypographyLayout = new javax.swing.GroupLayout(pnlTypography);
        pnlTypography.setLayout(pnlTypographyLayout);
        pnlTypographyLayout.setHorizontalGroup(
            pnlTypographyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 981, Short.MAX_VALUE)
        );
        pnlTypographyLayout.setVerticalGroup(
            pnlTypographyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 625, Short.MAX_VALUE)
        );

        pnlRight.add(pnlTypography, "card2");

        pnlParent.add(pnlRight, java.awt.BorderLayout.CENTER);

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
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-pay-40.png"))); // NOI18N
        jLabel12.setText("Thanh toán");
        btn_banHang.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 160, 40));

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
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-bill-30.png"))); // NOI18N
        jLabel5.setText("Hóa đơn");
        btn_hoaDon.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 120, -1));

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
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-staff-30.png"))); // NOI18N
        jLabel6.setText("Quản lý nhân viên");
        btn_nhanVien.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 10, 180, -1));

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
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-analytics-30.png"))); // NOI18N
        jLabel9.setText("Thống kê");
        btn_thongKe.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 10, 130, -1));

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
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-meat-30.png"))); // NOI18N
        jLabel10.setText("Quản lý hộp thịt");
        btn_hopThit.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 10, 170, -1));

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
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-discount-30.png"))); // NOI18N
        jLabel11.setText("Giảm giá");
        btn_giamGia.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 120, -1));

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
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-client-30.png"))); // NOI18N
        jLabel13.setText("Khách hàng");
        btn_khachHang.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 10, 140, -1));

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
                .addContainerGap(44, Short.MAX_VALUE))
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
                .addContainerGap(144, Short.MAX_VALUE))
        );

        pnlParent.add(sidepane, java.awt.BorderLayout.LINE_START);

        getContentPane().add(pnlParent, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    int xy, xx;

    private void lblMaximizeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMaximizeMousePressed
        if (FormThongKe.this.getExtendedState() == MAXIMIZED_BOTH) {
            FormThongKe.this.setExtendedState(JFrame.NORMAL);
        } else {
            FormThongKe.this.setExtendedState(MAXIMIZED_BOTH);
        }
    }//GEN-LAST:event_lblMaximizeMousePressed

    private void lblCloseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMousePressed
        System.exit(0);
    }//GEN-LAST:event_lblCloseMousePressed

    private void lblMinimizeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizeMousePressed
        FormThongKe.this.setState(Frame.ICONIFIED);
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
            if (FormThongKe.this.getExtendedState() == MAXIMIZED_BOTH) {
                FormThongKe.this.setExtendedState(JFrame.NORMAL);
            } else {
                FormThongKe.this.setExtendedState(MAXIMIZED_BOTH);
            }
        }
    }//GEN-LAST:event_pnlTopMouseClicked

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

        FormHopThit ht = new FormHopThit();
        ht.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_hopThitMousePressed

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

    private void sidepaneMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sidepaneMouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_sidepaneMouseDragged

    private void sidepaneMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sidepaneMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_sidepaneMousePressed

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
            java.util.logging.Logger.getLogger(FormThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new FormThongKe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JpnSp;
    private javax.swing.JPanel JpnTK;
    private javax.swing.JPanel btn_banHang;
    private javax.swing.JPanel btn_giamGia;
    private javax.swing.JPanel btn_hoaDon;
    private javax.swing.JPanel btn_hopThit;
    private javax.swing.JPanel btn_khachHang;
    private javax.swing.JPanel btn_nhanVien;
    private javax.swing.JPanel btn_thongKe;
    private javax.swing.JPanel ind_btns;
    private javax.swing.JPanel ind_data;
    private javax.swing.JPanel ind_fonts;
    private javax.swing.JPanel ind_giamGia;
    private javax.swing.JPanel ind_icons;
    private javax.swing.JPanel ind_khachHang;
    private javax.swing.JPanel ind_typo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblMaximize;
    private javax.swing.JLabel lblMinimize;
    private javax.swing.JPanel pnlActions;
    private javax.swing.JPanel pnlDataCards;
    private javax.swing.JPanel pnlParent;
    private javax.swing.JPanel pnlRight;
    private javax.swing.JPanel pnlTitle;
    private javax.swing.JPanel pnlTop;
    private javax.swing.JPanel pnlTypography;
    private javax.swing.JPanel sidepane;
    // End of variables declaration//GEN-END:variables
}
