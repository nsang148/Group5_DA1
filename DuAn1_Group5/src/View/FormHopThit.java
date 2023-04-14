/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Service.Implement.HopThitServices;
import Service.Implement.NCCServices;
import Service.Implement.QuanLyGiamGiaServiceImpl;
import Service.Implement.ThitService;
import Service.Implement.XuatXuService;
import Service.QuanLyGiamGiaService;
import ViewModels.HopThitView;
import ViewModels.NhaCCView;
import ViewModels.QuanLyGiamGia;
import ViewModels.ThitView;
import ViewModels.XuatXuView;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.data.cache.BigDecimalValues;

/**
 *
 * @author proxc
 */
public class FormHopThit extends javax.swing.JFrame {
    private DefaultTableModel dtm = new DefaultTableModel();
    private DefaultTableModel dtm2 = new DefaultTableModel();
    private DefaultTableModel dtm3 = new DefaultTableModel();
    private DefaultTableModel dtm4 = new DefaultTableModel();
    private DefaultTableModel dtm5 = new DefaultTableModel();
    private QuanLyGiamGiaService service1 = new QuanLyGiamGiaServiceImpl();
    private List<QuanLyGiamGia> listgg = new ArrayList<>();
    private List<ThitView> listt = new ArrayList<>();
    private List<HopThitView> listht = new ArrayList<>();
    private List<NhaCCView> listncc = new ArrayList<>();
    private NCCServices service4 = new NCCServices();
    private List<XuatXuView> listxx = new ArrayList<>();
    private XuatXuService service3 = new XuatXuService();
    private HopThitServices service5 = new HopThitServices();
    JButton myButton = new JButton();
    private ThitService service2 = new ThitService();
    private CardLayout cardLayout;
    ThitView tv = new ThitView();
    

    /**
     * Creates new form Home20
     */
    public FormHopThit() {
        initComponents();
        setLocationRelativeTo(null);
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
        dtm = (DefaultTableModel) tbl_GG.getModel();
        dtm4 = (DefaultTableModel) tblThit.getModel();
        dtm3 = (DefaultTableModel) tblNCC.getModel();
        dtm2 = (DefaultTableModel) tbl_xuatXu.getModel();
        dtm5 = (DefaultTableModel) tbl_hopthit.getModel();
        listht = service5.getal();
        listncc = service4.getAll();
        listt = service2.getAll();
        listgg = service1.getList();
        listxx = service3.getAll();
        taiDuLieuThit(listt);
        taiDuLieuNCC(listncc);
        loaddatagg(listgg);
        taiDuLieuXX(listxx);
        loaddatagght(listht);
        ImageIcon icon = new ImageIcon("images/add.png");
        myButton.setIcon(icon);
        add(myButton);
    }

    private void taiDuLieuThit(List<ThitView> listt) {
        dtm4.setRowCount(0);
        for (ThitView x : listt) {
                dtm4.addRow(new Object[]{x.getMa(),x.getTen(),x.getIdLT()});
        }
    } 
    private void taiDuLieuXX(List<XuatXuView> listxx) {
        dtm2.setRowCount(0);
        for (XuatXuView x : listxx) {
                dtm2.addRow(new Object[]{x.getTen()});
        }
    }    
     private void taiDuLieuNCC(List<NhaCCView> listncc) {
        dtm3.setRowCount(0);
        for (NhaCCView x : listncc) {
                dtm3.addRow(new Object[]{x.getTen(),x.getMa()});
        }
    }    
    private void loaddatagg(List<QuanLyGiamGia> listgg) {
        dtm.setRowCount(0);
        for (QuanLyGiamGia qlgg : listgg) {
            dtm.addRow(new Object[]{qlgg.getMa(),qlgg.getTen(),qlgg.getMucPhanTramGiamGia(),qlgg.getNgayBatDau(),qlgg.getNgayKetThuc()});
        }
    }    
        private void loaddatagght(List<HopThitView> listht) {
        dtm5.setRowCount(0);
        for (HopThitView x : listht) {
            dtm5.addRow(new Object[]{x.getMa(),x.getTenHopThit(),x.getGiaBan(),x.getGiaConLai(),x.getSoLuongTon(),x.getKhoiLuong(),x.getNgayDongGoi(),x.getHSD(),x.getMoTa(),x.setTrangThaiS(x.getTrangThai()),x.getGiaConLai()});
        }
    }
        private void filldataht(int index) {
        HopThitView ht = listht.get(index);
        txt_Ma.setText(ht.getMa());
        txt_ten.setText(ht.getTenHopThit());
        Txt_khoiluong.setText(String.valueOf(ht.getKhoiLuong()));
        txt_soluong.setText(String.valueOf(ht.getSoLuongTon()));
        txt_mota.setText(ht.getMoTa());
        txt_GiaBan.setText(String.valueOf(ht.getGiaBan()));
        txt_total.setText(String.valueOf(ht.getGiaConLai()));
        DCR_Ngaydonggoi.setDate(ht.getNgayDongGoi());
        DCR_HSD.setDate(ht.getHSD());
        if(ht.getTrangThai()==1){
            rdo_ban.setSelected(true);
        }else Rdo_khongban.setSelected(true);
        txt_TenThit.setText(ht.getTenHopThit());
        txt_loaithit.setText(ht.getIdloaiThit());
        Txt_GG.setText(ht.getIdGiamGia());
        Txt_ncc.setText(ht.getIdNCC());
        txt_xx.setText(ht.getIdXuatXu());
        }
    private HopThitView getDuLieu() {
        HopThitView ht = new HopThitView();
        ht.setMa(txt_Ma.getText());
        ht.setTenHopThit(txt_ten.getText());
        ht.setNgayDongGoi(DCR_Ngaydonggoi.getDate());
        ht.setHSD(DCR_HSD.getDate());
        ht.setGiaBan(Float.parseFloat(txt_GiaBan.getText()));
        ht.setSoLuongTon(Integer.valueOf(txt_soluong.getText()));
        ht.setKhoiLuong(Float.parseFloat(Txt_khoiluong.getText()));
        ht.setMoTa(txt_mota.getText());
       
        if (rdo_ban.isSelected()) {
            ht.setTrangThai(1);
        } else {
            ht.setTrangThai(0);
        }

        if (Rdo_khongban.isSelected()) {
            ht.setTrangThai(0);
        } else {
            ht.setTrangThai(1);
        }
        /*        ht.setGiaConLai(Float.parseFloat(txt_total.getText()));
        ht.setIdThit(txt_TenThit.getText());
        ht.setIdloaiThit(txt_loaithit.getText());
        ht.setIdXuatXu(txt_xx.getText());
        ht.setIdGiamGia(Txt_GG.getText());
        ht.setIdNCC(Txt_ncc.getText());
        ;*/
        return ht;
    }        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnlTop = new javax.swing.JPanel();
        pnlActions = new javax.swing.JPanel();
        lblMinimize = new javax.swing.JLabel();
        lblMaximize = new javax.swing.JLabel();
        lblClose = new javax.swing.JLabel();
        pnlTitle = new javax.swing.JPanel();
        pnlParent = new javax.swing.JPanel();
        pnlRight = new javax.swing.JPanel();
        pnlTypography = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_hopthit = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txt_Ma = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_ten = new javax.swing.JTextField();
        txt_GiaBan = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_soluong = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        Txt_khoiluong = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txt_mota = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        DCR_Ngaydonggoi = new com.toedter.calendar.JDateChooser();
        DCR_HSD = new com.toedter.calendar.JDateChooser();
        rdo_ban = new javax.swing.JRadioButton();
        Rdo_khongban = new javax.swing.JRadioButton();
        jLabel26 = new javax.swing.JLabel();
        txt_total = new javax.swing.JTextField();
        btn_add = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_GG = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblThit = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblNCC = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_xuatXu = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txt_xx = new javax.swing.JTextField();
        Txt_ncc = new javax.swing.JTextField();
        Txt_GG = new javax.swing.JTextField();
        txt_loaithit = new javax.swing.JTextField();
        txt_TenThit = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txt_search = new javax.swing.JTextField();
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

        pnlTypography.setPreferredSize(new java.awt.Dimension(1231, 644));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin hộp thịt", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(255, 0, 0))); // NOI18N

        tbl_hopthit.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Ma", "Tên HT", "Giá bán", "Số lượng còn", "Khối lượng", "Ngày đóng gói", "HSD", "Mô tả", "Trạng thái", "thành tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Integer.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_hopthit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_hopthitMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbl_hopthit);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 906, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "hộp thịt", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(255, 0, 0))); // NOI18N

        jLabel4.setText("Mã");

        txt_Ma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_MaActionPerformed(evt);
            }
        });

        jLabel8.setText("Tên");

        txt_ten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tenActionPerformed(evt);
            }
        });

        txt_GiaBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_GiaBanActionPerformed(evt);
            }
        });

        jLabel14.setText("Giá bán");

        jLabel15.setText("Số lượng");

        txt_soluong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_soluongActionPerformed(evt);
            }
        });

        jLabel16.setText("Khối lượng");

        Txt_khoiluong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_khoiluongActionPerformed(evt);
            }
        });

        jLabel17.setText("Ngày đóng gói");

        jLabel18.setText("HSD");

        txt_mota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_motaActionPerformed(evt);
            }
        });

        jLabel19.setText("Mô tả");

        jLabel20.setText("Trạng thái");

        buttonGroup1.add(rdo_ban);
        rdo_ban.setText("đang bán");

        buttonGroup1.add(Rdo_khongban);
        Rdo_khongban.setText("không bán");
        Rdo_khongban.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rdo_khongbanActionPerformed(evt);
            }
        });

        jLabel26.setText("Thành tiền");

        txt_total.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_total.setCaretColor(new java.awt.Color(255, 0, 0));

        btn_add.setText("thêm");
        btn_add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_addMouseClicked(evt);
            }
        });
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_xoa.setText("xóa");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addComponent(txt_GiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Txt_khoiluong, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(txt_soluong, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(txt_Ma, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel17)))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(Rdo_khongban)
                                            .addComponent(rdo_ban, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(DCR_Ngaydonggoi, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                                            .addComponent(DCR_HSD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(txt_mota, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(26, 26, 26))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_Ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DCR_Ngaydonggoi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_soluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Txt_khoiluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(DCR_HSD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdo_ban)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Rdo_khongban)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_mota, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_GiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Giản giá,  thịt ,loại thịt, nhà cung cấp, xuất xứ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(255, 0, 0))); // NOI18N
        jTabbedPane1.setForeground(new java.awt.Color(255, 0, 0));

        tbl_GG.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã giảm giá", "Tên chương trình", "Mức giảm", "ngày bắt đầu", "ngày kết thúc"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_GG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_GGMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_GG);

        jTabbedPane1.addTab("mã giảm giá", jScrollPane3);

        tblThit.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Tên thịt", "Mã", "tên loại"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblThit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThitMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblThit);

        jTabbedPane1.addTab("thịt", jScrollPane1);

        tblNCC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Tên nhà cung cấp", "Mã"
            }
        ));
        tblNCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNCCMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblNCC);

        jTabbedPane1.addTab("nhà cung cấp", jScrollPane2);

        tbl_xuatXu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "xuát xứ"
            }
        ));
        tbl_xuatXu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_xuatXuMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbl_xuatXu);

        jTabbedPane1.addTab("xuất xứ", jScrollPane5);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hộp thịt", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(255, 0, 0))); // NOI18N

        jLabel23.setText("thịt");

        jLabel24.setText("loại thịt");

        jLabel21.setText("mã giảm giá");

        jLabel25.setText("nhà cung cấp");

        jLabel22.setText("Xuất xứ");

        txt_xx.setEditable(false);
        txt_xx.setBackground(new java.awt.Color(204, 204, 204));
        txt_xx.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_xxCaretUpdate(evt);
            }
        });
        txt_xx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_xxActionPerformed(evt);
            }
        });

        Txt_ncc.setEditable(false);
        Txt_ncc.setBackground(new java.awt.Color(204, 204, 204));
        Txt_ncc.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                Txt_nccCaretUpdate(evt);
            }
        });
        Txt_ncc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_nccActionPerformed(evt);
            }
        });

        Txt_GG.setEditable(false);
        Txt_GG.setBackground(new java.awt.Color(204, 204, 204));
        Txt_GG.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                Txt_GGCaretUpdate(evt);
            }
        });
        Txt_GG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_GGActionPerformed(evt);
            }
        });

        txt_loaithit.setEditable(false);
        txt_loaithit.setBackground(new java.awt.Color(204, 204, 204));
        txt_loaithit.setMaximumSize(new java.awt.Dimension(273, 2147483647));
        txt_loaithit.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_loaithitCaretUpdate(evt);
            }
        });
        txt_loaithit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_loaithitActionPerformed(evt);
            }
        });

        txt_TenThit.setEditable(false);
        txt_TenThit.setBackground(new java.awt.Color(204, 204, 204));
        txt_TenThit.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_TenThitCaretUpdate(evt);
            }
        });
        txt_TenThit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_TenThitActionPerformed(evt);
            }
        });

        jButton2.setText("...");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jButton3.setText("...");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jButton5.setText("...");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });

        jButton6.setText("...");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_xx, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                            .addComponent(Txt_ncc, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Txt_GG, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_loaithit, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                            .addComponent(txt_TenThit))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_TenThit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_loaithit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Txt_GG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Txt_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_xx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(255, 0, 0))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlTypographyLayout = new javax.swing.GroupLayout(pnlTypography);
        pnlTypography.setLayout(pnlTypographyLayout);
        pnlTypographyLayout.setHorizontalGroup(
            pnlTypographyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(pnlTypographyLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlTypographyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTypographyLayout.createSequentialGroup()
                        .addGroup(pnlTypographyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlTypographyLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlTypographyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnlTypographyLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 941, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(149, 149, 149))
        );
        pnlTypographyLayout.setVerticalGroup(
            pnlTypographyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTypographyLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnlTypographyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlTypographyLayout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlTypographyLayout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
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
                .addContainerGap(97, Short.MAX_VALUE))
        );

        pnlParent.add(sidepane, java.awt.BorderLayout.LINE_START);

        getContentPane().add(pnlParent, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    int xy, xx;

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

    private void txt_MaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_MaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_MaActionPerformed

    private void txt_tenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tenActionPerformed

    private void txt_GiaBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_GiaBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_GiaBanActionPerformed

    private void txt_soluongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_soluongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_soluongActionPerformed

    private void Txt_khoiluongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_khoiluongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_khoiluongActionPerformed

    private void txt_motaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_motaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_motaActionPerformed

    private void Txt_nccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_nccActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_nccActionPerformed

    private void txt_xxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_xxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_xxActionPerformed

    private void txt_TenThitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_TenThitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TenThitActionPerformed

    private void txt_loaithitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_loaithitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_loaithitActionPerformed

    private void Txt_GGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_GGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_GGActionPerformed

    private void Rdo_khongbanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rdo_khongbanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Rdo_khongbanActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        new Thit().setVisible(true);
        
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        new LoaiThit().setVisible(true);
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        // TODO add your handling code here:
        new NhaCungCap().setVisible(true);
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        // TODO add your handling code here:
        new XuatXu().setVisible(true);
    }//GEN-LAST:event_jButton6MouseClicked

    private void tblThitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThitMouseClicked
        // TODO add your handling code here:
        int row = tblThit.getSelectedRow();

        txt_TenThit.setText(tblThit.getValueAt(row, 1).toString());
        txt_loaithit.setText(tblThit.getValueAt(row, 2).toString());
            
        
    }//GEN-LAST:event_tblThitMouseClicked

    private void tblNCCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNCCMouseClicked
        // TODO add your handling code here:
                int row = tblNCC.getSelectedRow();

        Txt_ncc.setText(tblNCC.getValueAt(row, 0).toString());
    }//GEN-LAST:event_tblNCCMouseClicked

    private void tbl_GGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_GGMouseClicked
        // TODO add your handling code here:
        int row = tbl_GG.getSelectedRow();

        Txt_GG.setText(tbl_GG.getValueAt(row, 0).toString());
    }//GEN-LAST:event_tbl_GGMouseClicked

    private void tbl_xuatXuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_xuatXuMouseClicked
        // TODO add your handling code here:
        int row = tbl_xuatXu.getSelectedRow();

        txt_xx.setText(tbl_xuatXu.getValueAt(row, 0).toString());        
    }//GEN-LAST:event_tbl_xuatXuMouseClicked

    private void tbl_hopthitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_hopthitMouseClicked
        // TODO add your handling code here:
                int row = tbl_hopthit.getSelectedRow();
                filldataht(row);
    }//GEN-LAST:event_tbl_hopthitMouseClicked

    private void btn_addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addMouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, service5.add(getDuLieu()));
        listht = service5.getal();
        loaddatagght(listht);
        
    }//GEN-LAST:event_btn_addMouseClicked

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_addActionPerformed

    private void txt_TenThitCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_TenThitCaretUpdate
        // TODO add your handling code here:
        service5.update(txt_TenThit.getText(),txt_Ma.getText());
        listht= service5.getal();
        loaddatagght(listht);        
        
        
    }//GEN-LAST:event_txt_TenThitCaretUpdate

    private void txt_loaithitCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_loaithitCaretUpdate
        

        // TODO add your handling code here:
        
        
        
    }//GEN-LAST:event_txt_loaithitCaretUpdate

    private void Txt_GGCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_Txt_GGCaretUpdate
        // TODO add your handling code here:
        service5.updateGG(Txt_GG.getText(),txt_Ma.getText());
        listht= service5.getal();
        loaddatagght(listht);  
    }//GEN-LAST:event_Txt_GGCaretUpdate

    private void Txt_nccCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_Txt_nccCaretUpdate
        // TODO add your handling code here:
        service5.updatencc(Txt_ncc.getText(),txt_Ma.getText());
        listht= service5.getal();
        loaddatagght(listht);        
    }//GEN-LAST:event_Txt_nccCaretUpdate

    private void txt_xxCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_xxCaretUpdate
            // TODO add your handling code here:
        service5.updatexx(txt_xx.getText(),txt_Ma.getText());
        listht= service5.getal();
        loaddatagght(listht);
    }//GEN-LAST:event_txt_xxCaretUpdate

    private void setIcon(JLabel jLabel, String url) throws IOException {
        try {
            ImageIcon icon = new ImageIcon(url);
            Image img = icon.getImage();
            Image resizedImg;
            resizedImg = img.getScaledInstance(460, 259, Image.SCALE_SMOOTH);
            ImageIcon resizedIcon = new ImageIcon(resizedImg);
            Image newImage = ImageIO.read(new File(url));
            icon.setImage(newImage);
            jLabel.setIcon(resizedIcon);
        } catch (IOException e) {
            jLabel.setIcon(null);
        }
    }



 



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
    private com.toedter.calendar.JDateChooser DCR_HSD;
    private com.toedter.calendar.JDateChooser DCR_Ngaydonggoi;
    private javax.swing.JRadioButton Rdo_khongban;
    private javax.swing.JTextField Txt_GG;
    private javax.swing.JTextField Txt_khoiluong;
    private javax.swing.JTextField Txt_ncc;
    private javax.swing.JButton btn_add;
    private javax.swing.JPanel btn_banHang;
    private javax.swing.JPanel btn_giamGia;
    private javax.swing.JPanel btn_hoaDon;
    private javax.swing.JPanel btn_hopThit;
    private javax.swing.JPanel btn_khachHang;
    private javax.swing.JPanel btn_nhanVien;
    private javax.swing.JPanel btn_thongKe;
    private javax.swing.JButton btn_xoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel ind_btns;
    private javax.swing.JPanel ind_data;
    private javax.swing.JPanel ind_fonts;
    private javax.swing.JPanel ind_giamGia;
    private javax.swing.JPanel ind_icons;
    private javax.swing.JPanel ind_khachHang;
    private javax.swing.JPanel ind_typo;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblMaximize;
    private javax.swing.JLabel lblMinimize;
    private javax.swing.JPanel pnlActions;
    private javax.swing.JPanel pnlParent;
    private javax.swing.JPanel pnlRight;
    private javax.swing.JPanel pnlTitle;
    private javax.swing.JPanel pnlTop;
    private javax.swing.JPanel pnlTypography;
    private javax.swing.JRadioButton rdo_ban;
    private javax.swing.JPanel sidepane;
    private javax.swing.JTable tblNCC;
    private javax.swing.JTable tblThit;
    private javax.swing.JTable tbl_GG;
    private javax.swing.JTable tbl_hopthit;
    private javax.swing.JTable tbl_xuatXu;
    private javax.swing.JTextField txt_GiaBan;
    private javax.swing.JTextField txt_Ma;
    private javax.swing.JTextField txt_TenThit;
    private javax.swing.JTextField txt_loaithit;
    private javax.swing.JTextField txt_mota;
    private javax.swing.JTextField txt_search;
    private javax.swing.JTextField txt_soluong;
    private javax.swing.JTextField txt_ten;
    private javax.swing.JTextField txt_total;
    private javax.swing.JTextField txt_xx;
    // End of variables declaration//GEN-END:variables
}
