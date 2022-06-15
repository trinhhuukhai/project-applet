package BTLCard;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import com.sun.javacard.apduio.*;
import java.util.List;
import javax.smartcardio.ATR;
import javax.smartcardio.Card;
import javax.smartcardio.CardChannel;
import javax.smartcardio.CardException;
import javax.smartcardio.CardTerminal;
import javax.smartcardio.CommandAPDU;
import javax.smartcardio.ResponseAPDU;
import javax.smartcardio.TerminalFactory;

public class ConnectApplet {

    private Apdu apdu;

    public static final byte[] AID_APPLET = {0x11, 0x22, 0x33, 0x44, 0x55, 0x00};
    Card card;
    CardChannel channel;
    CommandAPDU cmndAPDU;
    ResponseAPDU resAPDU;
    List<CardTerminal> terminals;
    private TerminalFactory factory;
    private CardTerminal terminal;

    public ConnectApplet() {
        apdu = new Apdu();
    }

    public boolean connectApplet() {
        try {
            // hiển thị danh sách các thiết bị đầu cuối có sẵn
            TerminalFactory factory = TerminalFactory.getDefault();
            terminals = factory.terminals().list();
            System.out.println("Terminals: " + terminals);
            // lấy terminal đầu tiên
            CardTerminal terminal = terminals.get(1);
            // thiết lập kết nối với thẻ
            card = terminal.connect("*");
            System.out.println("card: " + card);
            //  lấy ATR
            ATR atr = card.getATR();
            byte[] baAtr = atr.getBytes();
            System.out.print("ATR = 0x");
            for (int i = 0; i < baAtr.length; i++) {
                System.out.printf("%02X ", baAtr[i]);
            }
            channel = card.getBasicChannel();
            return true;
        } catch (CardException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void sendAPDUtoApplet(byte[] cmnds, byte[] data) {
        try {
            resAPDU = channel.transmit(new CommandAPDU(cmnds[0], cmnds[1], cmnds[2], cmnds[3], data));
        } catch (CardException e) {
            e.printStackTrace();
        }
    }


    public void sendAPDUtoApplet(byte[] cmnds) {
        try {
            resAPDU = channel.transmit(new CommandAPDU(cmnds[0], cmnds[1], cmnds[2], cmnds[3]));
        } catch (CardException e) {
            e.printStackTrace();
        }
    }

    public boolean disconnectApplet() {
        try {
            card.disconnect(false);
            return true;
        } catch (CardException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String byteToHex(byte data) {
        StringBuilder result = new StringBuilder();
        result.append(String.format("%02x", data));
        return result.toString();
    }

    public String shorttoHex(short data) {
        StringBuilder result = new StringBuilder();
        result.append(String.format("%02x", data));
        return result.toString();
    }

    public byte[] hexStringToByteArray(String s) {
        int len = s.length();
        System.out.println("len " + len);
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }

 
    //set Lc
    public void setTheDataLength(byte len) {
        apdu.Lc = len;
        System.out.println("Lc: " + byteToHex(len));
    }

    public void setTheDataLengthShort(short len) {
        apdu.Lc = len;
        System.out.println("Lc: " + shorttoHex(len));
    }
//
//    //gui du lieu den applet (tu mang data)

    public void setTheDataIn(byte[] data) {
        if (data.length != apdu.Lc) {
            System.err.println("The number of data in the array are more than expected");
        } else {
            //set the data to be sent to the applets
            apdu.dataIn = data;
            for (int i = 0; i < data.length; i++) {
                System.out.println("dataIndex" + i + ": " + byteToHex(data[i]));
            }
        }
    }
//
    //Le

    public void setExpctdByteLength(byte len) {
        apdu.Le = len;
        System.out.println("Le: " + byteToHex(len));
    }

    public void setExpctShortLength(short len) {
        apdu.Le = len;
        System.out.println("Le: " + shorttoHex(len));
    }
//

    //get sw1 sw2, convert to hex

    public byte[] decodeStatus() {
        byte[] statByte = apdu.getSw1Sw2();
        System.out.println("SW1: " + byteToHex(statByte[0]));
        System.out.println("SW2: " + byteToHex(statByte[1]));
        return statByte;
    }
//

}
