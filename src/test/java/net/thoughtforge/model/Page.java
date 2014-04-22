package net.thoughtforge.model;

import java.util.Iterator;
import java.util.List;
 
public interface Page<T> extends Iterable<T> {
 
  List<T> getContent();
 
  int getPageNumber();
 
  int getNumberOfElements();
 
  int getPageSize();
 
  long getTotalNumberOfElements();
 
  int getTotalPages();
 
  boolean hasNextPage();
 
  boolean hasPreviousPage();
 
  boolean isFirstPage();
 
  boolean isLastPage();
 
  @Override
  Iterator<T> iterator();
}