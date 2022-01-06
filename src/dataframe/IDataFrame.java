package dataframe;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import dataframe.composite.AComponent;
import dataframe.visitors.AVisitor;
import table.Row;
import table.Table;
import table.element.TableElement;

/**
 * Common interface for dataframes in this project,
 * most of the methods are implemented on table.Table.java.
 */
public interface IDataFrame extends AComponent {
	
	/**
	 * Returns the value of a single item by row and columName
	 * @param id row (from 0 to size()-1)
	 * @param label columnName
	 * @return TableElement on that position, if not found returns null
	 */
    TableElement at(int id, String label);

	/**
	 * Returns the value of a single item by row and column position
	 * @param row row index (from 0 to size()-1)
	 * @param col column index (from 0 to columns()-1)
	 * @return TableElement on that position, if not found returns null
	 */
    TableElement iat(int row, int col);

    /**
	 * Number of columns (number of labels)
	 * @return number of columns
	 */
    int columns();

    /**
	 * Number of elements (number of rows without counting the labels)
	 * @return number of elements
	 */
    int size();

    /**
	 * Sorts the table by one column and a specific criteria.
	 * TableElementComparator inside the package table.element can be used as comp parameter.
	 * @param columnName column name (label)
	 * @param comparator Comparator that implements a TableElement Comparator
	 * @return New sorted table
	 */
    Table sort(String columnName, Comparator<TableElement> comparator);

    /**
	 * Filters the table elements by specific criteria.
	 * Predicates can be found inside table.element.TableElement class
	 * @param label column name
	 * @param p predicate that will be used to filter the table
	 * @return New filtered table
	 */
    Table query(String label, Predicate<TableElement> p);

	List<Row> getRowList();


	/**
	 * Method needed to implement the visitor pattern
	 * @param visitor visitor that will be accepted
	 */
	@Override
	default void accept(AVisitor visitor) {
		visitor.visit(this);
	}
}