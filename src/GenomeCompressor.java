/******************************************************************************
 *  Compilation:  javac GenomeCompressor.java
 *  Execution:    java GenomeCompressor - < input.txt   (compress)
 *  Execution:    java GenomeCompressor + < input.txt   (expand)
 *  Dependencies: BinaryIn.java BinaryOut.java
 *  Data files:   genomeTest.txt
 *                virus.txt
 *
 *  Compress or expand a genomic sequence using a 2-bit code.
 ******************************************************************************/

/**
 *  The {@code GenomeCompressor} class provides static methods for compressing
 *  and expanding a genomic sequence using a 2-bit code.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 *  @author Zach Blick
 */
public class GenomeCompressor {

    /**
     * Reads a sequence of 8-bit extended ASCII characters over the alphabet
     * { A, C, T, G } from standard input; compresses and writes the results to standard output.
     */
    public static void compress() {
//        int a = 0;
//        int c = 1;
//        int t = 2;
//        int g = 3;

        // TODO: complete the compress() method
        String s = BinaryStdIn.readString();
        int n = s.length();
        Integer[] word = new Integer[85];
        word['A'] = 0;
        word['C'] = 1;
        word['T'] = 2;
        word['G'] = 3;
        char current;
        int BITS_Per_Char = 2;
        BinaryStdOut.write(n);
        for (int i =0; i < n; i++){
            current = s.charAt(i);
            BinaryStdOut.write(word[current], BITS_Per_Char);
        }
        BinaryStdOut.close();
    }

    /**
     * Reads a binary sequence from standard input; expands and writes the results to standard output.
     */
    public static void expand() {
        char[] word = new char[4];
        word[0] = 'A';
        word[1] = 'C';
        word[2] = 'T';
        word[3] = 'G';
        int current;
        // TODO: complete the expand() method
        int n = BinaryStdIn.readInt();
        for (int i = 0; i < n; i++){
            current = BinaryStdIn.readInt(2);
            BinaryStdOut.write(word[current]);
        }
        BinaryStdOut.close();
    }


    /**
     * Main, when invoked at the command line, calls {@code compress()} if the command-line
     * argument is "-" an {@code expand()} if it is "+".
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {

        if      (args[0].equals("-")) compress();
        else if (args[0].equals("+")) expand();
        else throw new IllegalArgumentException("Illegal command line argument");
    }
}