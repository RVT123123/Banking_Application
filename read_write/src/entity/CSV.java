package entity;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class CSV {
 
	 private final List<String[]> cells;

	    public CSV(File file) throws IOException {
	        cells = new ArrayList<>();
	        try (Scanner scan = new Scanner(file)) {
	            while (scan.hasNextLine()) {
	                String line = scan.nextLine();
	                cells.add(line.split(","));
	            }
	        }
	    }

	    public String get(int row, int col) {
	        String[] columns = cells.get(row - 1);
	        return columns[col - 1];
	    }

	    public CSV set(int row, int col, String value) {
	        String[] columns = cells.get(row - 1);
	        columns[col - 1] = value;
	        return this;
	    }

	    public void save(File file) throws IOException {
	        try (PrintWriter out = new PrintWriter(file)) {
	            for (String[] row : cells) {
	                for (String cell : row) {
	                    if (cell != row[0]) {
	                        out.print(",");
	                    }
	                    out.print(cell);
	                }
	                out.println();
	            }
	        }
	    }
}
