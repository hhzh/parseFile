package com.test;

public class TestString {

    public static void main(String[] args) {
        //String businessCode = "0101010101";
        //String cityCode = businessCode.substring(0, 6);
        //System.out.println(cityCode);

        String res = "nullnull看到nullnull";
        System.out.println(removeEndNullString(res));
    }

    private static String removeNullString(String note) {
        if (note != null && note.startsWith("null")) {
            note=note.substring(note.indexOf("null") + 4);
            note = removeNullString(note);
        }
        return note;
    }

    private static String removeEndNullString(String note) {
        if (note != null && note.endsWith("null")) {
            note=note.substring(0,note.lastIndexOf("null"));
            note = removeEndNullString(note);
        }
        return note;
    }
}
