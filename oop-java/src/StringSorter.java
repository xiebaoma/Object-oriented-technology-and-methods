import java.io.*;
import java.util.*;

public class StringSorter {
    public static void main(String[] args) {
        File inputFile = new File("lunch.java");
        File outputFile = new File("inverse.txt");

        LinkedList<String> lines = new LinkedList<>();

        // 读取文件并将每行添加到List中
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.err.println("读取文件失败: " + e.getMessage()); 
            return;
        }

        // 使用自定义Comparator排序（忽略大小写，按转大写后的降序）
        lines.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s2.toUpperCase().compareTo(s1.toUpperCase()); // 降序
            }
        });

        // 将内容逆序写入输出文件
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            ListIterator<String> iterator = lines.listIterator(lines.size());
            while (iterator.hasPrevious()) {
                writer.write(iterator.previous());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("写入文件失败: " + e.getMessage());
        }

        System.out.println("排序完成，结果已写入 inverse.txt");
    }
}
