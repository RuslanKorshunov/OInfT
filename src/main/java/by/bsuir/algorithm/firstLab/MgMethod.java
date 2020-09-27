package by.bsuir.algorithm.firstLab;

import by.bsuir.algorithm.Method;
import by.bsuir.entity.Matrix;

public class MgMethod implements Method {
    @Override
    public Matrix math(Matrix matrix, Matrix vectorResult) {
        Matrix vectorSolution = null;

        if (matrix.getN() == matrix.getM() && matrix.getN() == vectorResult.getM()) {
            Matrix matrixExtended = new Matrix(matrix, matrix.getN() + 1, matrix.getM());
            for (int i = 0; i < matrix.getM(); i++) {
                int n = matrixExtended.getN() - 1;
                double value = vectorResult.get(0, i);
                matrixExtended.set(value, n, i);
            }

            System.out.println(
                    "Extended matrix.\n" +
                            matrixExtended +
                            "\nGaussian forward stroke. \n" + matrixExtended);
            for (int i = 0; i < matrixExtended.getN() - 1; i++) {
                double elementMain = matrixExtended.get(i, i);
                if (elementMain == 0) {
                    int mNew = i;
                    for (int j = i + 1; j < matrixExtended.getM(); j++) {
                        if (mNew < matrixExtended.get(i, j)) {
                            mNew = j;
                        }
                    }
                    if (i != mNew) {
                        matrixExtended.swapRows(i, mNew);
                        elementMain = matrixExtended.get(i, i);
                    }
                }
                for (int j = i + 1; j < matrixExtended.getM(); j++) {
                    double element = matrixExtended.get(i, j);
                    if (element != 0) {
                        double k = element / elementMain;
                        for (int ii = i; ii < matrixExtended.getN(); ii++) {
                            double valueNew = matrixExtended.get(ii, j) - k * matrixExtended.get(ii, i);
                            matrixExtended.set(valueNew, ii, j);
                        }
                    }
                }
                System.out.println("Step " + (i + 1) + ".\n" + matrixExtended);
            }
            System.out.println("Gaussian forward stroke. Result\n" + matrixExtended);

            reduceElements(matrixExtended);
            System.out.println("Reduce elements.\n" + matrixExtended);

            vectorSolution = GaussianReversal(matrixExtended);
            System.out.println("Solution vector.\n" + vectorSolution);
        }

        return vectorSolution;
    }

    private void reduceElements(Matrix matrix) {
        for (int i = 0; i < matrix.getM(); i++) {
            double elementMain = matrix.get(i, i);
            if (elementMain != 0) {
                for (int j = i; j < matrix.getN(); j++) {
                    double valueNew = matrix.get(j, i) / elementMain;
                    matrix.set(valueNew, j, i);
                }
            }
        }
    }

    private Matrix GaussianReversal(Matrix matrix) {
        Matrix result = new Matrix((Double) null, 1, matrix.getM());

        for (int i = matrix.getM() - 1; i >= 0; i--) {
            double x = matrix.get(matrix.getN() - 1, i);
            for (int j = matrix.getN() - 2; j > i; j--) {
                double value = matrix.get(j, i);
                Double k = result.get(0, j);
                if (k != null) {
                    x -= value * k;
                } else {
                    break;
                }
            }
            result.set(x, 0, i);
        }

        return result;
    }

/*    private boolean checkRank(Matrix matrix) {
        boolean result = true;

        for (int i = matrix.getM() - 1; i >= 0; i--) {
            int zeroNumber = 0;
            for (int j = 0; j <= matrix.getN() - 2; j++) {
                if (matrix.get(j, i) == 0) {
                    zeroNumber++;
                }
            }
            if (zeroNumber == matrix.getN() - 2 && matrix.get(matrix.getN() - 1, i) == 0) {
                result = false;
                break;
            }
        }

        return result;
    }*/
}
