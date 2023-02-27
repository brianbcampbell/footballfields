package net.codejava;

public class DrawFieldService {

    public static final String IMAGE_FILE_NAME = "field.png"; //exists in "static" dir
    //field measurements
    private static final int FIELD_X_FT = 300;
    private static final int FIELD_Y_FT = 160;


    public static DrawField getDrawField(FormData formData) {
        System.out.println(formData);
        DrawField result;
        if (formData.getAcres() > 0)
            result = getResultByAcres(formData.getAcres());
        else if (formData.getSqft() > 0)
            result = getResultBySqft(formData.getSqft());
        else if (formData.getLengthft() > 0 && formData.getWidthft() > 0)
            result = getResultByLW(formData.getLengthft(), formData.getWidthft());
        else
            result = new DrawField();
        return result;
    }

    private static DrawField getResultByLW(int xft, int yft) {
        DrawField result = new DrawField();
        result.setRequest(xft + "ft x " + yft + "ft");

        result.setXft(xft);
        result.setYft(yft);

        result.setBgXpx(FIELD_X_FT * getMultiplier(xft, FIELD_X_FT));
        result.setBgYpx(FIELD_Y_FT * getMultiplier(yft, FIELD_Y_FT));

        return result;
    }

    private static DrawField getResultBySqft(int sqft) {
        int[] legs = getLegs(sqft);
        DrawField result = getResultByLW(legs[0], legs[1]);
        result.setRequest(sqft + " ft^2");
        return result;
    }

    private static DrawField getResultByAcres(double acres) {

        final int sqftPerAcre = 43560;
        int sqft = (int) (acres * sqftPerAcre);
        DrawField result = getResultBySqft(sqft);
        result.setRequest(acres + " acres");
        return result;
    }

    public static int[] getLegs(int sqft) {
        int y = (int) Math.sqrt(sqft * 160.0 / 300.0);
        int x = (int) sqft / y;
        return new int[]{x, y};
    }

    public static int getMultiplier(int leg, int dimension) {
        if (leg < dimension) return 1;
        int i = 2;
        while (i * dimension < leg) i++;
        return i;
    }
}
