@Test
public void countingWordsOfEmptyBookReturnsZero() {
	 // Given
	 Book book = new Book("someISBN");
	 
	 // When
	 double wordCount = BookStats.countWords(book);
	 
	 // Then
	 assertEquals(0, wordCount);
} 
