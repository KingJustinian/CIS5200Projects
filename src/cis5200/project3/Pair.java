package cis5200.project3;

import java.util.Comparator;

/**
 * CIS5200-W01
 * Project 3, Problem 20.8 + Additional Instructions
 * Justin Burden
 *
 * @author Justin Burden
 * @param <F>
 * @param <S>
 */
public class Pair<F extends Number, S extends Number> {

    private F firstElement;
    private S secondElement;

    public Pair() {
        // Nothing to initialize to
        firstElement = null;
        secondElement = null;
    }

    public Pair(F firstElem, S secondElem) {
        this.firstElement = firstElem;
        this.secondElement = secondElem;
    }

    /**
     * @return the firstElement
     */
    public F getFirstElement() {
        return firstElement;
    }

    /**
     * @param firstElement the firstElement to set
     */
    public void setFirstElement(F firstElement) {
        this.firstElement = firstElement;
    }

    /**
     * @return the secondElement
     */
    public S getSecondElement() {
        return secondElement;
    }

    /**
     * @param secondElement the secondElement to set
     */
    public void setSecondElement(S secondElement) {
        this.secondElement = secondElement;
    }

    public static Comparator createComparator() {
        return new PairComparator();
    }
    
    @Override
    public String toString() {
        return String.format("Pair(%s, %s)", firstElement,
                secondElement);
    }
}
