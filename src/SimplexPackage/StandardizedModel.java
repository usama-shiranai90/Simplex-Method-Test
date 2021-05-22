package SimplexPackage;

import java.util.ArrayList;
import java.util.LinkedList;

/*
    class use to Formulate Problem,
    here i standardized the LP-Problem into Simplex Procedure.
 */
public class StandardizedModel {

    private int totalNoConstraints;  // number of constraints  -> e.g by calling size of ls_con or rs_con method.
    private int totalFunctionVariables;  // number of original variables   ->  Objective function ka variables ko show kary ga.
    private ArrayList<ArrayList<Double>> tableaux;

    private String[] rowField;
    private String[] columnField;

    public StandardizedModel() {

    }

    public StandardizedModel(LinkedList<Double> objectiveFunction, LinkedList<LinkedList<Double>> lsConstraint,
                             LinkedList<Double> rsConstraint) {

        totalNoConstraints = rsConstraint.size();
        totalFunctionVariables = objectiveFunction.size();
        tableaux = new ArrayList<>();                 /**
         * Original = [4][4]  -> but we need to add slack-variables:
         *  if 4 constraints then 4 slack
         *  1 for right side constraint.   [4] [9]
         */

        rowField = new String[totalNoConstraints + 1];// addition 1 for Cj-Zj
        columnField = new String[totalFunctionVariables + totalNoConstraints + 1];

        int slackIncrement = totalFunctionVariables;

        // initialize constraint
        for (int row = 0; row < totalNoConstraints + 1; row++) {  // 4 constraint and 1 for O-Fun
            tableaux.add(new ArrayList<>());

            boolean slackFlag = false;

            rowField[row] = "s" + (row + 1);

            for (int column = 0; column < (totalFunctionVariables + totalNoConstraints + 1); column++) {  // 5 < 9
//                System.out.println("row = " + row + "   tableaux.size = " + tableaux.size());

                if (row == totalNoConstraints) {

                    rowField[row] = "Cj-Zj";
                    if (column < objectiveFunction.size())
                        tableaux.get(row).add(objectiveFunction.get(column));
                    else
                        tableaux.get(row).add(0.0);
                }

                else if (column < totalFunctionVariables) {      // for adding left constraints.

                    tableaux.get(row).add(lsConstraint.get(row).get(column));
                    columnField[column] = "x" + (column + 1);

                } else if (column < (totalFunctionVariables + totalNoConstraints)) {    // adding slacks section      4 < 7

                    if (slackIncrement == column && !slackFlag) {   // 4 == 4
                        tableaux.get(row).add(1.0);
                        slackFlag = true;
                        slackIncrement++;   //  SI = 5

                    } else
                        tableaux.get(row).add(0.0);
                    columnField[column] = "s" + (row + 1);


                } else {         // right constraint
                    tableaux.get(row).add(rsConstraint.get(row));
                    columnField[column] = "profit";
                }

            }

        }

        show();
    }


    public int getTotalNoConstraints() {
        return totalNoConstraints;
    }

    public int getTotalFunctionVariables() {
        return totalFunctionVariables;
    }

    public ArrayList<ArrayList<Double>> getTableaux() {
        return tableaux;
    }

    public void show() {

        for (int i = 0; i <= totalNoConstraints; i++) {
            System.out.print(rowField[i] + "   ");
            for (int j = 0; j <= totalNoConstraints + totalFunctionVariables; j++) {

                System.out.printf("%7.2f ", tableaux.get(i).get(j));
            }
            System.out.println();
        }


    }

}
