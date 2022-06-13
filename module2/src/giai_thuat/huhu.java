package giai_thuat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class huhu {

    huhu() {
            System.out.print("abc");
        }

        class Bar {
            Bar() {
                System.out.print("tobar");
            }

            public void go() {
                System.out.print("ok");
            }
        }

        public static void main(String[] args) {
            huhu f = new huhu();
            f.createBar();
        }

        void createBar() {
            (new Bar() {
            }).go();
        }

}
