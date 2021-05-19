package SimplexPackage;
/* Z =  2100.0x1 + 6400.0x2 + 5500.0x3 + 6000.0x4

S1      12x1 + 8x2 + 7x3 + 8x4 + S1 ≤ 85
S2      3x1 + 9x2 + 11x3 + 13x4 + S2 ≤ 75
S3      4x1 +6x2 + 8x3 + 19x4 + S3 ≤ 122
S4      15x1 + 11x2 + 13x3 + 17x4 + S4 ≤ 90   */
public class Main {

    public static void main(String[] args) {
        LPModel model = new LPModel();

        System.out.println("model.getLsConstraint().size() = " + model.getLsConstraint().size());
        System.out.println("model.getRsConstraint().size() = " + model.getRsConstraint().size());
        System.out.println(model.printLPMODEL());

        StandardizedModel standardizedModel = new StandardizedModel(
                model.getObjectiveFunction(), model.getLsConstraint(),
                model.getOperatorConstraints(),model.getRsConstraint()
        );

    }


}
