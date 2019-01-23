package cis5200.project3;

import java.util.Comparator;

/**
 * CIS5200-W01
 * Project 3, Problem 20.8 + Additional Instructions
 * Justin Burden
 *
 * @author Justin Burden
 */
public class PairComparator implements Comparator<Pair> {

    @Override
    public int compare(Pair p1, Pair p2) {
        double p1Dist = 0.0;
        if (p1.getFirstElement() != null && p1.getSecondElement() != null) {
            p1Dist = Math.hypot(p1.getFirstElement().doubleValue(),
                    p1.getSecondElement().doubleValue());
        }
        double p2Dist = 0.0;
        if (p2.getFirstElement() != null && p2.getSecondElement() != null) {
            p2Dist = Math.hypot(p2.getFirstElement().doubleValue(),
                    p2.getSecondElement().doubleValue());
        }

        if (p1Dist > p2Dist) {
            return 1;
        } else if (p1Dist < p2Dist) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object c) {

        if (this == c) {
            return true;
        }
        if (c == null) {
            return false;
        }

        return this.getClass().equals(c.getClass());
    }
}
