
package Pb2;

public class Vers {
    private String v;

    public void set_v(String c) {
        this.v = c;
    }

    public String get_v() {
        return this.v;
    }

    public Vers(String v) {
        this.v = v;
    }

    public int nrcuv() {
        String[] words = v.split("\\s+");
        return words.length;
    }

    public int nrvoc() {
        int count = 0;
        String vocale = "aăâeiîouAĂÂEIÎOU";
        for (char ch : v.toCharArray()) {
            if (vocale.contains(String.valueOf(ch)))
                count++;
        }
        return count;
    }

    public void Steluta(String s) {
        if (v.endsWith(s)) {
            v = "*" +v;
        }
    }

    public void Rand(double r) {
        if (r < 0.1) {
            v = v.toUpperCase();
        }
    }
}

