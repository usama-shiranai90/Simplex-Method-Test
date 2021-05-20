
import java.util.*;
import java.util.stream.IntStream;

public class Testing {


    /*
S1      12x1 + 8x2 + 7x3 + 8x4 + S1 ≤ 85
S2      3x1 + 9x2 + 11x3 + 13x4 + S2 ≤ 75
S3      4x1 +6x2 + 8x3 + 19x4 + S3 ≤ 122
S4      15x1 + 11x2 + 13x3 + 17x4 + S4 ≤ 90
     */

    static ArrayList<String> rows = new ArrayList<>();
    static ArrayList<String> cols = new ArrayList<>();
    static ArrayList<ArrayList<Double>> data = new ArrayList<>();

/*    public static void main(String[] args) {

        rows.addAll(Arrays.asList("S1", "S2", "S3", "S4"));
        cols.addAll(Arrays.asList("x1", "x2", "x3", "x4"));

        data.add(new ArrayList<>());
        data.get(0).addAll(Arrays.asList(12.0, 3.0, 4.0, 15.0));
        data.add(new ArrayList<>());
        data.get(1).addAll(Arrays.asList(8.0, 9.0, 6.0, 11.0));
        data.add(new ArrayList<>());
        data.get(2).addAll(Arrays.asList(7.0, 11.0, 8.0, 13.0));
        data.add(new ArrayList<>());
        data.get(3).addAll(Arrays.asList(8.0, 13.0, 19.0, 17.0));

        Table<String, String, Double> tableForm = HashBasedTable.create();
        //  0 -> x1 s1 ->
        for (int i = 0; i < rows.size() ; i++) {
            for (int inner= 0 ; inner< data.get(i).size() ;inner++){
                tableForm.put(rows.get(i),
                        cols.get(inner),
                        data.get(inner).get(i));
            }

        }

        for (Table.Cell<String, String, Double> cell: tableForm.cellSet()){
            System.out.println(cell.getRowKey()+" "+cell.getColumnKey()+" "+cell.getValue());
        }

        System.out.println("==================\nInitial TABLE.cellSet \n==================\n" + tableForm.cellSet());


    }*/


    public static void main(String[] args) {

        List<Double> list = new ArrayList<>(Collections.nCopies(10, 0.0));
        IntStream.iterate(0, i->i).limit(list.size()).forEach(value -> {
            System.out.print(list.get(value)+"  ");
        });

    }














}
