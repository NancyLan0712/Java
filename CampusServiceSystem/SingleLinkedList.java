package CampusServiceSystem;

import java.util.function.Predicate;

import org.w3c.dom.Node;


public class SingleLinkedList {
	private Book head = new Book("","",0);
	public Book getHead() {
		return head;
	}
	
	//插入书籍
	public void insert(Book newBook, int position) {
	    if (position < 0) {
	        System.out.println("Invalid position");
	        return;
	    }

	    Book temp = head;
	    int i = 1; 

	 
	    while (temp.next != null && i < position) {
	        temp = temp.next;
	        i++;
	    }

	    newBook.next = temp.next;
	    temp.next = newBook;
	}
	//添加书籍
	public void add(Book heroNode) {
		Book temp =head;
		while(true) {
			if(temp.next==null) {
				break;
			}
			
			temp = temp.next;
		}
		temp.next = heroNode;
	}
	 // 按书名取书
    public Book getBookByName(String name) {
        return getBook(book -> book.name.equals(name));
    }

    // 按作者取书
    public Book getBookByAuthor(String author) {
        return getBook(book -> book.author.equals(author));
    }

    // 通用的查找方法
    private Book getBook(Predicate<Book> condition) {
        Book temp = head.next;
        while (temp != null) {
            if (condition.test(temp)) {
                return temp; // 找到符合条件的书籍，返回该书籍对象
            }
            temp = temp.next;
        }
        return null; // 未找到符合条件的书籍，返回null
    }
	//按编号顺序存书
	public void addByOrder(Book BookNode) {
		Book temp = head;
		boolean flag=false;
		while(true) {
			if(temp.next==null) {
				break;
			}else if(temp.next.no>BookNode.no) {
				break;
			}else if(temp.next.no==BookNode.no){
				flag=true;
				break;
				
			}
			temp=temp.next;
		}
		if(flag) {
			System.out.printf("书编号%d存在\n",BookNode.no);
			
		
		}
		else {
			BookNode.next=temp.next;
			temp.next=BookNode;
		}
		
	}
	//按编号更新
	public void upDate(Book BookNode) {
		Book temp =head.next;
		boolean flag  = false;
		while(true) {
			if(temp==null) {
				break;
			
			}else if(temp.no==BookNode.no) {
				flag=true;
				break;
			}
			temp = temp.next;
		}
		if(flag) {
			temp.name = BookNode.name;
			temp.author=BookNode.author;
		}else {
			System.out.printf("没找到编号为%d的书\n",BookNode.no);
		}
	}
	//按编号删除
	public void del(Student checkedOutStudent) {
	    Book temp = head;
	    boolean flag = false;
	    while(true) {
	        if(temp.next == null) {
	            break;  // 当temp.next为空时，结束循环
	        } else if(temp.next.no == checkedOutStudent) {
	            flag = true;
	            break;
	        }
	        temp = temp.next;
	    }
	    if(flag) {
	        temp.next = temp.next.next;
	    } else {
	        System.out.printf("没找到编号为%d的书\n", checkedOutStudent);
	    }
	}
		
		//借书
	public void borrow(int no, SingleLinkedList borrowedBooks) {
	    Book temp = head;
	    while (temp.next != null) {
	        if (temp.next.no == no) {
	            Book borrowedBook = temp.next;
	            temp.next = temp.next.next; // 从当前链表中移除书籍

	            borrowedBook.next = null; // 确保借出的书籍不会指向其他书籍
	            borrowedBooks.add(borrowedBook); // 添加到借出书籍的链表中
	            return;
	        }
	        temp = temp.next;
	    }
	    System.out.printf("没找到编号为%d的书\n", no);
	}

	  //打印链表
	public void list() {
		Book temp = head.next;
		if(temp==null) {
			System.out.println("链表为空");
			return;
		
		}
		while(true) {
			if(temp==null) {
				break;
			}
			System.out.println(temp);
		temp=temp.next;
		}
		
	}

	private Node head1;
    public void add(Student student) {
        Node newNode = new Node(student);

        if (head1 == null) {
            head1 = newNode;
        } else {
            Node current = head1;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }


    public Student getStudentByName(String name) {
        Node current = head1;

        while (current != null) {
            if (current.student.getName().equalsIgnoreCase(name)) {
                return current.student;
            }
            current = current.next;
        }

        return null; // Student not found
    }
}