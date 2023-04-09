/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DomainModels.ThongKeDT;
import DomainModels.ThongKeSP;
import Service.Implement.ThongKeServiceImpl;
import Service.ThongKeService;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author tagot
 */
public class QuanLyThongKeController {
    
    private ThongKeService thongkeservice = null;

    public QuanLyThongKeController() {
        thongkeservice = new ThongKeServiceImpl();
    }
    public void setTienTochart(JPanel jpnItem){
        List<ThongKeDT> listItem = thongkeservice.getListTK();
        if (listItem != null) {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            for(ThongKeDT tk: listItem) {
                dataset.addValue(tk.getTongtienngay(), "Tổng Doanh Thu Theo Ngày",tk.getNgayThanhToan());
            }
            JFreeChart barchart = ChartFactory.createBarChart("THỐNG KÊ DOANH THU THEO NGÀY", "Ngày", "Doanh Thu",dataset,PlotOrientation.VERTICAL, false, true, false);
            ChartPanel chartPanel = new ChartPanel(barchart);
            chartPanel. setPreferredSize(new Dimension(jpnItem.getWidth(), 285));
            
            jpnItem.removeAll();
            jpnItem.setLayout(new CardLayout());
            jpnItem.add(chartPanel);
            jpnItem.validate();
            jpnItem.repaint();
            
        }
    }
        public void setSPTochart(JPanel jpnItem){
        List<ThongKeSP> listItem = thongkeservice.getListSP();
        if (listItem != null) {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            for(ThongKeSP sp: listItem) {
                dataset.addValue(sp.getSoLuongBan(), "Tổng Sản Phẩm Bán Được",sp.getTen());
            }
            JFreeChart barchart = ChartFactory.createBarChart("THỐNG KÊ SẢN PHẨM BÁN CHẠY", "Tên", "Số Lượng",dataset,PlotOrientation.VERTICAL, false, true, false);
            ChartPanel chartPanel = new ChartPanel(barchart);
            chartPanel. setPreferredSize(new Dimension(jpnItem.getWidth(), 285));
            
            jpnItem.removeAll();
            jpnItem.setLayout(new CardLayout());
            jpnItem.add(chartPanel);
            jpnItem.validate();
            jpnItem.repaint();
            
        }
    }
    
    
}
