package wzq.com.lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * author:Created by WangZhiQiang on 2019/5/31.
 */
public class io {

    public static void main(String[] args) throws IOException {

        File f = new File("a.txt");
        FileOutputStream fop = new FileOutputStream(f);
        // ����FileOutputStream����,�ļ������ڻ��Զ��½�
        OutputStreamWriter writer = new OutputStreamWriter(fop, "UTF-8");
        // ����OutputStreamWriter����,��������ָ������,Ĭ��Ϊ����ϵͳĬ�ϱ���,windows����gbk

        writer.append("��������");
        // д�뵽������

        writer.append("\r\n");
        // ����

        writer.append("English");
        // ˢ�»����,д�뵽�ļ�,��������Ѿ�û��д���������,ֱ��closeҲ��д��

        writer.close();
        // �ر�д����,ͬʱ��ѻ���������д���ļ�,���������ע�͵�

        fop.close();
        // �ر������,�ͷ�ϵͳ��Դ






        FileInputStream fip = new FileInputStream(f);
        // ����FileInputStream����

        InputStreamReader reader = new InputStreamReader(fip, "UTF-8");
        // ����InputStreamReader����,������д����ͬ

        StringBuffer sb = new StringBuffer();
        while (reader.ready()) {
            sb.append((char) reader.read());
            // ת��char�ӵ�StringBuffer������
        }
        System.out.println(sb.toString());
        reader.close();
        // �رն�ȡ��

        fip.close();
        // �ر�������,�ͷ�ϵͳ��Դ

    }
}
