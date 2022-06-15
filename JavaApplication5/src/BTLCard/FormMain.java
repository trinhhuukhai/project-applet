/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTLCard;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import javafx.scene.layout.Pane;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author khaia
 */
public class FormMain extends javax.swing.JFrame {

    private ConnectApplet connectApplet;
    private JFrame frame;
    static byte counter;
    static boolean ts_du = false;
    static Customer customer;
    private boolean input = false;

    private boolean cardready = false;
    private boolean connected = false;
    public byte[] rsaPubKey = new byte[128];

    /**
     * Creates new form NewJFrame
     */
    public FormMain() {

        initComponents();
        customer = new Customer();
        connectApplet = new ConnectApplet();

        slide();
        setImage();
        setLocationRelativeTo(null);

    }

    public void slide() {
        final int labelWidth = 530;
        final AtomicInteger labelPadding = new AtomicInteger();
        Timer timer = new Timer(40, (ActionEvent e) -> {
            txtRun.setBorder(new EmptyBorder(0, labelPadding.getAndIncrement() % labelWidth, 0, 0));
        });
        timer.start();
    }

    public void setImage() {
        ImageIcon image1 = new ImageIcon(new ImageIcon("C:/Users/khaia/Desktop/anh/1.jpg").getImage().getScaledInstance(170, 150, Image.SCALE_DEFAULT));
        ImageIcon image2 = new ImageIcon(new ImageIcon("C:/Users/khaia/Desktop/anh/2.jpg").getImage().getScaledInstance(170, 150, Image.SCALE_DEFAULT));

        ImageIcon image3 = new ImageIcon(new ImageIcon("C:/Users/khaia/Desktop/anh/3.jpg").getImage().getScaledInstance(200, 150, Image.SCALE_DEFAULT));
        ImageIcon image4 = new ImageIcon(new ImageIcon("C:/Users/khaia/Desktop/anh/avarta.jpg").getImage().getScaledInstance(120, 150, Image.SCALE_DEFAULT));

        labelImage1.setIcon(image1);
        labelImage2.setIcon(image2);
        labelImage3.setIcon(image3);
        avatar.setIcon(image4);

    }

    //hien thi apdu lenh len GUI
    public void setTheCommandAPDUOnGUI(byte[] cmnds, byte[] data, byte lc, byte le) {
//        text_cla.setText(host.atrToHex(cmnds[0]));
//        text_ins.setText(host.atrToHex(cmnds[1]));
//        text_p1.setText(host.atrToHex(cmnds[2]));
//        text_p2.setText(host.atrToHex(cmnds[3]));
//        text_lc.setText(host.atrToHex(lc));
        //data
        String temp = "";
        for (int i = 0; i < data.length; i++) {
            temp += connectApplet.byteToHex(data[i]);
            temp += " ";
        }
//        text_data_cmd.setText(temp);
//        text_le.setText(host.atrToHex(le));
    }
//

    public void setTheCommandAPDUOnGUI2(byte[] cmnds, byte[] data, short lc, short le) {
//        text_cla.setText(host.atrToHex(cmnds[0]));
//        text_ins.setText(host.atrToHex(cmnds[1]));
//        text_p1.setText(host.atrToHex(cmnds[2]));
//        text_p2.setText(host.atrToHex(cmnds[3]));
//        text_lc.setText(host.shorttoHex(lc));
//        //data
        String temp = "";
        for (int i = 0; i < data.length; i++) {
            temp += connectApplet.byteToHex(data[i]);
            temp += " ";
        }
//        text_data_cmd.setText(temp);
//        text_le.setText(host.shorttoHex(le));
    }
//
//    //hien thi apdu phan hoi len GUI

    public void setTheResponseAPDUOnGUI(short le) {
        byte[] status = connectApplet.decodeStatus();//sw1 sw2
//        text_sw1.setText(String.valueOf(host.atrToHex(status[0])));
//        text_sw2.setText(String.valueOf(host.atrToHex(status[1])));
        byte[] dataOut = connectApplet.resAPDU.getData();//du lieu nhan ve tu applet
        if (le != 0 && dataOut.length != 0) {
            //hien thi du lieu ra
            String temp = "";
            for (int i = 0; i < dataOut.length; i++) {
                temp += connectApplet.byteToHex(dataOut[i]);
                temp += " ";
            }
//            text_data_rs.setText(temp);
        }
    }

    public void setCommandAPDU(byte[] cmnds, byte lc, byte[] data, byte le) {
//        txt_cla.setText(thebus.byteToHex(cmnds[0]));
//        txt_ins.setText(thebus.byteToHex(cmnds[1]));
//        txt_p1.setText(thebus.byteToHex(cmnds[2]));
//        txt_p2.setText(thebus.byteToHex(cmnds[3]));
//        txt_lc.setText(thebus.byteToHex(lc));
        //data
        String temp = "";
        for (int i = 0; i < data.length; i++) {
            temp += connectApplet.byteToHex(data[i]);
            temp += " ";
        }
//        txt_cmd.setText(temp);
//        txt_le.setText(thebus.byteToHex(le));
    }

    //hien thi apdu phan hoi len
    public void setResponseAPDU(byte[] datares, short le) {
        int status1 = connectApplet.resAPDU.getSW1();
        int status2 = connectApplet.resAPDU.getSW2();
//        txt_sw1.setText(thebus.shorttoHex((short) status1));
//        txt_sw2.setText(thebus.shorttoHex((short) status2));
        if (le != 0 && datares.length != 0) {
            //hien thi du lieu ra
            String temp = "";
            for (int i = 0; i < datares.length; i++) {
                temp += connectApplet.byteToHex(datares[i]);
                temp += " ";
            }
//            txt_respon.setText(temp);
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

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtRun = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        btnKetnoi = new javax.swing.JButton();
        btnngatketnoi = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtpin = new javax.swing.JPasswordField();
        btnXacnhan = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        labelImage1 = new javax.swing.JLabel();
        labelImage3 = new javax.swing.JLabel();
        labelImage2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        avatar = new javax.swing.JLabel();
        labelHoTen = new javax.swing.JLabel();
        labelNgaySinh = new javax.swing.JLabel();
        labelGioiTinh = new javax.swing.JLabel();
        labelSoDienThoai = new javax.swing.JLabel();
        labelQueQuan = new javax.swing.JLabel();
        labelht = new javax.swing.JLabel();
        labelns = new javax.swing.JLabel();
        labelgt = new javax.swing.JLabel();
        labelqq = new javax.swing.JLabel();
        labelsdt = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("jButton1");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtRun.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        txtRun.setText("Welcome Hotel");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(txtRun)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtRun)
                .addGap(20, 20, 20))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton7.setText("Khởi tạo");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton8.setText("Gửi đến Applet");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton10.setText("Dịch vụ");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton2.setText("Nạp tiền");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton3.setText("Xóa thẻ");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addGap(5, 5, 5)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton8))))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton8))
                .addGap(35, 35, 35)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton10)
                    .addComponent(jButton2))
                .addGap(21, 21, 21))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnKetnoi.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnKetnoi.setText("Kết nối");
        btnKetnoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKetnoiActionPerformed(evt);
            }
        });

        btnngatketnoi.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnngatketnoi.setText("Ngắt kết nối");
        btnngatketnoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnngatketnoiActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton5.setText("Mở khóa thẻ");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Nhập mã pin:");

        txtpin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpinActionPerformed(evt);
            }
        });

        btnXacnhan.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnXacnhan.setText("Xác nhận");
        btnXacnhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacnhanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(btnKetnoi, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnngatketnoi))
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtpin, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnXacnhan, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKetnoi)
                    .addComponent(btnngatketnoi))
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addGap(12, 12, 12)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtpin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnXacnhan)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setPreferredSize(new java.awt.Dimension(102, 405));

        labelImage1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        labelImage3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        labelImage2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelImage3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelImage2, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelImage3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("@2022");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(459, 459, 459)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setText("Thẻ khách hàng");

        avatar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        labelHoTen.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        labelHoTen.setText("Họ tên:");

        labelNgaySinh.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        labelNgaySinh.setText("Ngày sinh:");

        labelGioiTinh.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        labelGioiTinh.setText("Giới tính:");

        labelSoDienThoai.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        labelSoDienThoai.setText("Số điện thoại:");

        labelQueQuan.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        labelQueQuan.setText("Quê quán:");

        labelht.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        labelht.setText("null");

        labelns.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        labelns.setText("null");

        labelgt.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        labelgt.setText("null");

        labelqq.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        labelqq.setText("null");

        labelsdt.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        labelsdt.setText("null");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(avatar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(labelNgaySinh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelGioiTinh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelQueQuan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelSoDienThoai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(labelHoTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelns, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelht, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(labelgt, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                        .addGap(83, 83, 83))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelsdt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelqq, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(83, 83, 83))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(168, 168, 168))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel3)
                .addGap(74, 74, 74)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(avatar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelHoTen)
                            .addComponent(labelht))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelNgaySinh)
                            .addComponent(labelns))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelGioiTinh)
                            .addComponent(labelgt))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelQueQuan)
                    .addComponent(labelqq))
                .addGap(28, 28, 28)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSoDienThoai)
                    .addComponent(labelsdt))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtpinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpinActionPerformed

    private void btnKetnoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKetnoiActionPerformed
//        byte datalen = 6; //do dai du lieu gui vao applet, RID,PIX 
//        byte maxdata_expect = 0;//du lieu nhan mong doi (Le)
//        counter = 3;
//        connectApplet.establishConnectionToSimulator();//thiet lap ket noi
//        connectApplet.pwrUp();//cung cap dien
//        byte[] cmd = {(byte) 0x00, (byte) 0xA4, (byte) 0x04, (byte) 0x00};// select
//        connectApplet.setTheAPDUCommands(cmd);//set APDU header
//        connectApplet.setTheDataLength(datalen);//LC
//        //mang data gui di la RID,PIX 0XC0 0X90 0X59 0X8E 0XF4 0X78
//        byte[] data = {(byte) 0xC0, (byte) 0x90, (byte) 0x59, (byte) 0x8E, (byte) 0xF4, (byte) 0x78};
//        //byte[] data = {(byte) 0xE5, (byte) 0xaf, (byte) 0x0e, (byte) 0x46, (byte) 0xd8, (byte) 0xdf};
//        connectApplet.setTheDataIn(data);//gui du lieu toi applet
//        connectApplet.setExpctdByteLength(maxdata_expect);//LE
//        setTheCommandAPDUOnGUI(cmd, data, datalen, maxdata_expect);//hien thi apdu cmd len GUI
//        connectApplet.exchangeTheAPDUWithSimulator();//nhan du lieu phan hoi
//        connectApplet.decodeStatus();//sw1 sw2
//        setTheResponseAPDUOnGUI(maxdata_expect);//hien thi du lieu phan hoi tu applet len GUI
//        JOptionPane.showMessageDialog(this, "Ket noi voi the thanh cong");
//        text_connect.setText("Done");
//        text_close.setText("");

        if (connectApplet.connectApplet() == true) {;//thiet lap ket noi
            byte[] cmd = {(byte) 0x00, (byte) 0xA4, (byte) 0x04, (byte) 0x00};// select
            //mang data gui di la RID,PIX
            byte[] data = {(byte) 0x11, (byte) 0x22, (byte) 0x33, (byte) 0x44, (byte) 0x55, (byte) 0x00};
            byte lc = 6;
            byte le_expect = 2;
            setCommandAPDU(cmd, lc, data, le_expect);//hien thi apdu cmd
            connectApplet.sendAPDUtoApplet(cmd, data);
            byte[] dataRes = connectApplet.resAPDU.getData();
            int le = connectApplet.resAPDU.getNr();
            setResponseAPDU(dataRes, (short) le);//hien thi du lieu phan hoi tu applet
            btnKetnoi.setText("Đang kết nối...");
            btnngatketnoi.setText("Ngắt kết nối");
            connected = true;
        } else {
            JOptionPane.showMessageDialog(this, "Kết nối không thành công. Hãy thử lại.");
        }

    }//GEN-LAST:event_btnKetnoiActionPerformed

    private void btnngatketnoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnngatketnoiActionPerformed
//        connectApplet.pwrDown();
//        connectApplet.closeConnection();
//
//        labelHoTen.setText("");
//        labelGioiTinh.setText("");
//        labelNgaySinh.setText("");
//        labelQueQuan.setText("");
//        labelSoDienThoai.setText("");

        if (connectApplet.disconnectApplet() == true) {
            btnKetnoi.setText("Kết nối");
//        btnKetnoi.setBackground(Color.gray);
            btnngatketnoi.setText("Đã ngắt kết nối");
//        btnngatketnoi.setBackground(Color.red);

            connected = false;
            cardready = false;

            labelht.setText(null);
            labelns.setText(null);
            labelqq.setText(null);
            labelgt.setText(null);
            labelsdt.setText(null);
        } else {
            JOptionPane.showMessageDialog(this, "Ngắt kết nối không thành công.");
        }

    }//GEN-LAST:event_btnngatketnoiActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
//        if (input == false) {
//            FormKhoiTao fkt = new FormKhoiTao();
//            fkt.setVisible(true);
//            fkt.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        }

        if (connected == true) {
            if (input == false) {
                FormKhoiTao fkt = new FormKhoiTao();
                fkt.setVisible(true);
                fkt.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            } else {
                JOptionPane.showMessageDialog(null, "Thẻ đã có dữ liệu");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Chưa connect thẻ");
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
//        if (input == false) {
//            //chuyen du lieu xuong applet
//            String hoten = customer.getHoTen();
//            String ngaysinh = customer.getNgaySinh();
//            String quequan = customer.getQueQuan();
//            String pin = customer.getMapin();
//            String sodienthoai = customer.getSoDienThoai();
//            String gioitinh = customer.getGioiTinh();

//            String arrsend = new StringBuilder().append(hoten).append(".").append(ngaysinh).append(".").append(quequan).append(".").append(gioitinh).append(".").append(sodienthoai).append(".").append(pin).toString();
//            String arrsendapplet = hoten.concat(".").concat(ngaysinh).concat(".").concat(quequan).concat(".").concat(gioitinh).concat(".").concat(sodienthoai).concat(".").concat(pin);
//            System.out.println(hoten + ngaysinh + quequan + pin + sodienthoai + gioitinh);
//            JOptionPane.showMessageDialog(null, pin);
//            int len = arrsendapplet.length();
//            byte datalen = (byte) len; //do dai du lieu gui vao applet
//            byte maxdata_expect = 127;//du lieu nhan mong doi (Le)
//            byte[] cmd = {(byte) 0x80, (byte) 0x10, (byte) 0x00, (byte) 0x00};
//            connectApplet.setTheAPDUCommands(cmd);//set APDU header
//            connectApplet.setTheDataLength(datalen);//LC
////            mang data gui di la RID,PIX
//            byte[] data = arrsendapplet.getBytes();
//            connectApplet.setTheDataIn(data);//gui du lieu toi applet
//            connectApplet.setExpctdByteLength(maxdata_expect);//LE
//            setTheCommandAPDUOnGUI(cmd, data, datalen, maxdata_expect);//hien thi apdu cmd len GUI
//            connectApplet.exchangeTheAPDUWithSimulator();//nhan du lieu phan hoi
//            connectApplet.decodeStatus();//sw1 sw2
//            setTheResponseAPDUOnGUI(maxdata_expect);//hien thi du lieu phan hoi tu applet len GUI
//            byte[] dataOut = connectApplet.decodeDataOut();//du lieu nhan ve tu applet
//            String out = new String(dataOut);
//            String[] aaa = out.split(":");
//            String ht1 = aaa[0];
//            String ht2 = aaa[1];
//            String ht3 = aaa[2];
//            String ht4 = aaa[3];
//            String ht5 = aaa[4];
//            System.out.println(ht1);
//            txthoten.setText(ht1);
//            txtns.setText(ht2);
//            txtqq.setText(ht3);
//            txtgt.setText(ht4);
//            txtsdt.setText(ht5);
//            JOptionPane.showMessageDialog(this, "Gui den applet thanh cong");
//        } else {
//            JOptionPane.showMessageDialog(null, "Card already has data.");
//        }
        if (connected == true) {
            if (input == false) {
//                setImage(info.getAvatar());
//                getImage(info.getAvatar());
                //chuyen du lieu xuong applet
                String hoten = customer.getHoTen();
                String ngaysinh = customer.getNgaySinh();
                String quequan = customer.getQueQuan();
                String pin = customer.getMapin();
                String sodienthoai = customer.getSoDienThoai();
                String gioitinh = customer.getGioiTinh();;

                String arrsendapplet = hoten.concat(".").concat(ngaysinh).concat(".").concat(quequan).concat(".").concat(gioitinh).concat(".").concat(sodienthoai).concat(".").concat(pin);
//                String arraysend = sothe.concat(".").concat(hoten).concat(".").concat(ngaysinh).concat(".").concat(pin);
                System.out.println("send:" + arrsendapplet);
                int lc = arrsendapplet.length();
                byte datalen = (byte) lc; //do dai du lieu gui vao applet
                byte[] cmd = {(byte) 0xA0, (byte) 0x10, (byte) 0x00, (byte) 0x00};
                byte[] data = arrsendapplet.getBytes();
                setCommandAPDU(cmd, (byte) lc, data, (byte) 0);
                connectApplet.sendAPDUtoApplet(cmd, data);
                byte[] dataRes = connectApplet.resAPDU.getData();
                int le = connectApplet.resAPDU.getNr();
                setResponseAPDU(dataRes, (byte) le);//hien thi du lieu phan hoi tu applet
//                String tach = new String(dataRes);
//                System.out.print("a:" + tach);
//                String[] a = tach.split(":");
//                String ht1 = a[0];
//                String ht2 = a[1];
//                String ht3 = a[2];
//                String ht4 = a[3];
//                String ht5 = a[4];
//                System.out.println(a);
//                labelHoTen.setText(ht1);
//                labelNgaySinh.setText(ht2);
//                labelQueQuan.setText(ht3);
//                labelGioiTinh.setText(ht4);
//                labelSoDienThoai.setText(ht5);

//                byte[] cmd1 = {(byte) 0xA0, (byte) 0x21, (byte) 0x00, (byte) 0x00};
//                connectApplet.sendAPDUtoApplet(cmd1);
//                byte[] b = connectApplet.resAPDU.getData();
//                String sodu = "";
//                for (int i = 0; i < b.length; i++) {
//                    sodu += connectApplet.byteToHex(b[i]);
//                }
//                txt_sodu.setText("" + Integer.valueOf(sodu, 16).intValue() * 1000);
                input = true;
                JOptionPane.showMessageDialog(this, "Gửi dữ liệu đến Applet thành công");
            } else {
                JOptionPane.showMessageDialog(null, "Thẻ đã có dữ liệu.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Thẻ chưa kết nối");
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void btnXacnhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacnhanActionPerformed
        // TODO add your handling code here:
        if (checkcard() == false) {
            if (checkpin() == true) {
                get_info_kh();

            } else {
                JOptionPane.showMessageDialog(null, "Mã PIN sai. Vui lòng nhập lại.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Thẻ bị khóa do nhập sai mã PIN quá 3 lần");
        }
    }//GEN-LAST:event_btnXacnhanActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        short datalen = 1; //do dai du lieu gui vao applet
        short maxdata_expect = 0;//du lieu nhan mong doi (Le)
        byte[] cmd = {(byte) 0x80, (byte) 0x11, (byte) 0x00, (byte) 0x00};
        connectApplet.sendAPDUtoApplet(cmd);//set APDU header
        connectApplet.setTheDataLengthShort(datalen);//LC
        //mang data gui di la RID,PIX
        byte[] data_u = {(byte) 0};
        connectApplet.setTheDataIn(data_u);
        //host.setExpctdByteLength(maxdata_expect);//LE
        connectApplet.setExpctShortLength(maxdata_expect);
        setTheCommandAPDUOnGUI2(cmd, data_u, datalen, maxdata_expect);//hien thi apdu cmd len GUI
//        connectApplet.exchangeTheAPDUWithSimulator();//nhan du lieu phan hoi
        connectApplet.decodeStatus();//sw1 sw2
        setTheResponseAPDUOnGUI(maxdata_expect);//hien thi du lieu phan hoi tu applet len GUI
        connectApplet.decodeStatus();//sw1 sw2
        setTheResponseAPDUOnGUI(maxdata_expect);//hien thi du lieu phan hoi tu applet len GUI
        JOptionPane.showMessageDialog(null, "Thẻ đã được mở khóa.");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (connected == true) {
            if (checkpin() == true) {
                if (input == true) {
                    FormNapTien fnt = new FormNapTien();
                    fnt.setVisible(true);
                    fnt.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Chưa connect thẻ || Chưa khởi tạo thông tin thẻ");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        if (connected == true) {
            if (checkpin() == true) {
                if (input == true) {
                    FormDichVu fdv = new FormDichVu();
                    fdv.setVisible(true);
                    fdv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Chưa connect thẻ || Chưa khởi tạo thông tin thẻ");
        }

    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (connected == true) {
            if (input == false) {
                JOptionPane.showMessageDialog(null, "Thẻ chưa có dữ liệu.");
            } else {
                byte[] cmd = {(byte) 0xA0, (byte) 0x15, (byte) 0x00, (byte) 0x00};
                byte[] data = {0};
                setCommandAPDU(cmd, (byte) 0, data, (byte) 0);//hien thi apdu cmd len GUI
                connectApplet.sendAPDUtoApplet(cmd);
                byte[] dataRes = connectApplet.resAPDU.getData();
                int le = connectApplet.resAPDU.getNr();
                setResponseAPDU(dataRes, (short) le);//hien thi du lieu phan hoi tu applet
                labelht.setText("");
                labelgt.setText("");
                labelns.setText("");
                labelqq.setText("");
                labelsdt.setText("");
                JOptionPane.showMessageDialog(null, "Thẻ đã xóa dữ liệu.");
                input = false;
            }

        } else {
            JOptionPane.showMessageDialog(null, "Chưa connect thẻ");
        }
    }//GEN-LAST:event_jButton3ActionPerformed
    private void get_info_kh() {
//        short datalen = 1; //do dai du lieu gui vao applet
//        short maxdata_expect = 200;//du lieu nhan mong doi (Le)
//        byte[] cmd = {(byte) 0x80, (byte) 0x13, (byte) 0x00, (byte) 0x00};
//        connectApplet.sendAPDUtoApplet(cmd);//set APDU header
//        connectApplet.setTheDataLengthShort(datalen);//LC
//        //mang data gui di la RID,PIX
//        byte[] data_u = {(byte) 0};
//        connectApplet.setTheDataIn(data_u);
//        //host.setExpctdByteLength(maxdata_expect);//LE
//        connectApplet.setExpctShortLength(maxdata_expect);
//        setTheCommandAPDUOnGUI2(cmd, data_u, datalen, maxdata_expect);//hien thi apdu cmd len GUI
////        connectApplet.exchangeTheAPDUWithSimulator();//nhan du lieu phan hoi
//        connectApplet.decodeStatus();//sw1 sw2
//        setTheResponseAPDUOnGUI(maxdata_expect);//hien thi du lieu phan hoi tu applet len GUI
//        connectApplet.decodeStatus();//sw1 sw2
//        setTheResponseAPDUOnGUI(maxdata_expect);//hien thi du lieu phan hoi tu applet len GUI
//        setCommandAPDU(cmd, (byte) datalen, data_u, (byte) 0);
//        connectApplet.sendAPDUtoApplet(cmd, data_u);
//        byte[] dataRes = connectApplet.resAPDU.getData();
        byte[] cmd = {(byte) 0xA0, (byte) 0x13, (byte) 0x00, (byte) 0x00};
        byte[] data_u = {(byte) 0};
        short datalen = 1;
        short maxdata_expect = 256;
        connectApplet.setTheDataIn(data_u);
        setCommandAPDU(cmd, (byte) datalen, data_u, (byte) maxdata_expect);
        connectApplet.sendAPDUtoApplet(cmd, data_u);
        byte[] dataRes = connectApplet.resAPDU.getData();
        int le = connectApplet.resAPDU.getNr();
        setResponseAPDU(dataRes, (byte) le);//hien thi du lieu phan hoi tu applet
        String tach = new String(dataRes);
        System.out.print("a:" + tach);
        String[] a = tach.split(":");
        String ht1 = a[0];
        String ht2 = a[1];
        String ht3 = a[2];
        String ht4 = a[3];
        String ht5 = a[4];
        System.out.println(ht1);
        labelht.setText(ht1);
        labelns.setText(ht2);
        labelgt.setText(ht3);
        labelqq.setText(ht4);
        labelsdt.setText(ht5);

    }

    //check xem thẻ bị khóa hay chưa (OK)
    private boolean checkcard() {
        short datalen = 1; //do dai du lieu gui vao applet
        short maxdata_expect = 1;//du lieu nhan mong doi (Le)
        byte[] cmd = {(byte) 0x80, (byte) 0x14, (byte) 0x00, (byte) 0x00};
        connectApplet.sendAPDUtoApplet(cmd);
        connectApplet.setTheDataLengthShort(datalen);
        byte[] data_u = {(byte) 0};
        connectApplet.setTheDataIn(data_u);
        connectApplet.setExpctShortLength(maxdata_expect);
        setTheCommandAPDUOnGUI2(cmd, data_u, datalen, maxdata_expect);
//        connectApplet.exchangeTheAPDUWithSimulator();
        connectApplet.decodeStatus();
        setTheResponseAPDUOnGUI(maxdata_expect);
        byte[] dataOut = connectApplet.resAPDU.getData();//du lieu nhan ve tu applet
        if (dataOut[0] == (byte) 0x00) {//chưa bị khóa, Ok
            return false;
        } else {
            return true;
        }
    }

    //gửi mã PIN vào applet để applet check (OK)
    private boolean checkpin() {
        String pin = Arrays.toString(txtpin.getPassword());
        short datalen = (short) pin.length(); //do dai du lieu gui vao applet
        short maxdata_expect = 1;//du lieu nhan mong doi (Le)
        byte[] cmd = {(byte) 0x80, (byte) 0x16, (byte) 0x00, (byte) 0x00};
        connectApplet.sendAPDUtoApplet(cmd);
        connectApplet.setTheDataLengthShort(datalen);
        byte[] data_u = pin.getBytes();
        connectApplet.setTheDataIn(data_u);
        connectApplet.setExpctShortLength(maxdata_expect);
        setTheCommandAPDUOnGUI2(cmd, data_u, datalen, maxdata_expect);
//        connectApplet.exchangeTheAPDUWithSimulator();
        connectApplet.decodeStatus();
        setTheResponseAPDUOnGUI(maxdata_expect);

        setCommandAPDU(cmd, (byte) datalen, data_u, (byte) maxdata_expect);
        connectApplet.sendAPDUtoApplet(cmd, data_u);
        byte[] dataRes = connectApplet.resAPDU.getData();
        int le = connectApplet.resAPDU.getNr();

        byte[] dataOut = connectApplet.resAPDU.getData();//du lieu nhan ve tu applet
        if (dataOut[0] == (byte) 0x00) {//đúng mã PIN
            return true;
        } else {
            return false;
        }
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
            java.util.logging.Logger.getLogger(FormMain.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMain.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMain.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMain.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avatar;
    private javax.swing.JButton btnKetnoi;
    private javax.swing.JButton btnXacnhan;
    private javax.swing.JButton btnngatketnoi;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel labelGioiTinh;
    private javax.swing.JLabel labelHoTen;
    private javax.swing.JLabel labelImage1;
    private javax.swing.JLabel labelImage2;
    private javax.swing.JLabel labelImage3;
    private javax.swing.JLabel labelNgaySinh;
    private javax.swing.JLabel labelQueQuan;
    private javax.swing.JLabel labelSoDienThoai;
    private javax.swing.JLabel labelgt;
    private javax.swing.JLabel labelht;
    private javax.swing.JLabel labelns;
    private javax.swing.JLabel labelqq;
    private javax.swing.JLabel labelsdt;
    private javax.swing.JLabel txtRun;
    private javax.swing.JPasswordField txtpin;
    // End of variables declaration//GEN-END:variables
}
