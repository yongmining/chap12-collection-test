package com.greedy.section01.list.run;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.greedy.section01.list.comparator.AscendingPrice;
import com.greedy.section01.list.dto.BookDTO;

public class Application2 {

	public static void main(String[] args) {

		List<BookDTO> booklist = new ArrayList<>();

		booklist.add(new BookDTO(1, "홍길동전", "허균",50000));
		booklist.add(new BookDTO(2, "목민심서", "정약용",30000));
		booklist.add(new BookDTO(3, "동의보감", "허준",40000));
		booklist.add(new BookDTO(4, "삼국사가", "김부식",46000));
		booklist.add(new BookDTO(5, "삼국유사", "일연",58000));

		//		for(int i = 0; i < booklist.size(); i++) {
		//			System.out.println(booklist.get(i));
		//		}

		for(BookDTO book : booklist) {
			System.out.println(book);
		}

		//		booklist.forEach(System.out::println);

		booklist.sort(new AscendingPrice());

		System.out.println("가격 순 오름차순 정렬 ==================");
		for(BookDTO book : booklist) {
			System.out.println(book);

		}

		/* 익명클래스는 {}를 만들어서 마치 Comparator 인터페이스를 상속받은 클래스를 작성하는 것과 같이 사용된다.*/
		booklist.sort(new Comparator<BookDTO>() {

			@Override
			public int compare(BookDTO o1, BookDTO o2) {

				return o1.getPrice() >= o2.getPrice()? -1 : 1;
			}

		});

		/* 람다식 활용 */
		//	booklist.sort((BookDTO b1, BookDTO b2) -> b1.getPrice() >= b2.getPrice()? -1 : 1);

		System.out.println("가격 순 내림차순 정렬 ======================");
		for(BookDTO book : booklist) {
			System.out.println(book);
		}

		/* 제목 순 오름차순 정렬 */
		booklist.sort(new Comparator <BookDTO>() {

			@Override
			public int compare(BookDTO o1, BookDTO o2) {

				/* compareTo() : 앞의 값이 더작은 경우 음수 반환,
				 * 같으면 0 반환, 앞의 갑이 더 큰 경우 양수 반환
				 * */
				return o1.getTitle().compareTo(o2.getTitle());
			}
		});
		System.out.println("제목 순 오름차순 정렬 ========================");
		for (BookDTO book : booklist) {
			System.out.println(book);

			/* 제목 순 내림차순 정렬 */
			booklist.sort(new Comparator<BookDTO>() {

				@Override
				public int compare(BookDTO o1, BookDTO o2) {

					return o1.getTitle().compareTo(o2.getTitle()) * -1;

				}
			});

			System.out.println("제목 순 내림차순 정렬 ====================");
			for(BookDTO book1 : booklist) {
				System.out.println(book1);
			}
			booklist.sort(new Comparator <BookDTO>() {

				@Override
				public int compare(BookDTO a1, BookDTO a2) {
					
					return a1.getAuthor().compareTo(a2.getAuthor()) * -1;
				}
			});
			
					System.out.println("저자순 오름차순 정렬 =========================");
					for (BookDTO book1 : booklist) {
						System.out.println(book1);
					}



				}
			}
		}
