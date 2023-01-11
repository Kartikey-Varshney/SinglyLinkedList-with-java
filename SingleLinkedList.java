import javax.xml.stream.events.EndElement;

// Exceptions
class ElementNotFoundException extends  Exception
{
    public ElementNotFoundException(String str)
    {
        super(str);
    }
}
public class SingleLinkedList<T>
{

    Node head; // head of LinkedList.
    int size; // size of LinkedList.

    // Method for adding element in LinkedList.

    void insert(T nodedata)
    {
        Node node = new Node(nodedata);
        if (head == null)
        {
            head = node;
            size++;
            return;
        }
        else
        {
            Node temp = head;
            while(temp.next!=null)
            {
                temp = temp.next;
            }
            temp.next = node;
            size++;
        }
    }

    // Method of insert element at a given position.

    void insertInto(T dataToBeAdd , int position)
    {
        int count = 1;
        Node node = new Node(dataToBeAdd);
        Node temp = head;
        Node temp2 = null;
        if ( position == 1)
        {
            node.next = head;
            head = node;
            size++;
            return;
        }
        if ( position == size)
        {
            while(temp.next!=null)
            {
                temp = temp.next;
            }
            temp.next = node;
            size++;
            return;
        }
        while(count<position-1)
        {
            temp = temp.next;
            temp2 = temp.next;
            count++;
        }
        temp.next = node;
        node.next = temp2 ;
        size++;
        return ;
    }


    // Method for display the LinkedList.

    void Display()
    {
        if(head == null)
        {
            System.out.println("List is empty.");
            return;
        }
        else
        {
            Node temp = head;
            while(temp.next!= null)
            {
                System.out.print(temp.data+" ");
                temp= temp.next;
            }
            System.out.println(temp.data);
        }
    }

    // Method for finding first occurrence in LinkedList.


    int FindFirstOccurrence(T dataToBeSearch ) throws ElementNotFoundException
    {
        Node temp = head;
        int index = 0 ;
        boolean found = false;
        while(temp.next != null)
        {
            index++;
            if( temp.data == dataToBeSearch)
            {
                found = true;
                break;
            }
            temp = temp.next;
        }
        if ( found == false)
        {
            throw new ElementNotFoundException("Element is not available in List.");
        }
        return index;

    }

    // Method for find last occurrence in LinkedList.

    int FindLastOccurrence(T dataToBeSearch) throws ElementNotFoundException
    {

        Node temp = head;
        int index = 0;
        int Last_index = 0;
        while (temp != null)
        {
            index++;
            if (temp.data==dataToBeSearch)
            {
                Last_index = index;
            }
            temp= temp.next;
        }
        if(Last_index == 0 )
        {
            throw new ElementNotFoundException("Element is not available in List.");
        }
        return Last_index;
    }

    // Method for finding all occurrences of an element in LinkedList.

    void FindAllOccurrences(T dataToBeSearch) throws ElementNotFoundException
    {
        int index = 0;
        boolean found = false;
        Node temp = head;
        while (temp != null) {
            index++;
            if (temp.data == dataToBeSearch) {
                System.out.print(index + " ");
                found = true;
            }
            temp = temp.next;
        }
        System.out.println();
        if (found == false)
        {
            throw new ElementNotFoundException("Element is not available in List.");
        }
        return ;
    }

    // Method for count all occurrences of an element in LinkedList.

    int CountAllOccurrences(T dataToBeSearch) throws ElementNotFoundException
    {
        int count = 0 ;
        Node temp = head;
        while ( temp != null)
        {
            if (temp.data == dataToBeSearch)
            {
                count++;
            }
            temp = temp.next;
        }
        if (count == 0)
        {
            throw new ElementNotFoundException("Element is not available in List.");
        }
        return count;

    }

    // Method for inserting data after the selected element.

    void insertAfter(  T dataToBeAdd , T searchedData    ) throws  ElementNotFoundException
    {
        Node temp =  head;
        Node temp2 = temp.next;
        boolean found = false;
        Node node = new Node(dataToBeAdd);
        if(head == null)
        {
            System.out.println("The list is empty can't perform insert operation.");
            return ;
        }
        while(temp!= null)
        {
            if (temp.data == searchedData)
            {
                temp.next = node;
                node.next = temp2;
                found = true;
                size++;
                break;
            }
            temp = temp.next;
            temp2 = temp.next;
        }
        if (found == false)
        {
            throw new ElementNotFoundException("Element is not available in List.");
        }

    }

    // Method for inserting data before the selected element.

    void insertBefore(  T dataToBeAdd , T searchedData ) throws ElementNotFoundException
    {
        Node temp = head;
        Node temp2 = null ;
        boolean found = false;
        Node node = new Node(dataToBeAdd);
        if(head == null)
        {
            System.out.println("The list is empty can't perform insert operation.");
            return ;
        }
        if(temp.data == searchedData)
        {
            node.next = head;
            head = node;
            size++;
            return ;
        }
        while(temp!=null)
        {
            if (temp.data == searchedData )
            {
                temp2.next = node;
                node.next = temp;
                found = true;
                size++;
                break;
            }
            temp2 = temp;
            temp = temp.next;
        }
        if ( found != true)
        {
            throw new ElementNotFoundException("Element is not available in List.");

        }
    }

    // Method for removing first occurrence of an element in LinkedList.

    void remove(T dataToBeRemove) throws ElementNotFoundException
    {
        Node temp = head;
        Node temp2 = null;
        boolean found = false;
        if ( head == null)
        {
            System.out.println("List is empty.");
            return ;
        }
        if( head.data == dataToBeRemove)
        {
            temp = temp.next;
            head = temp;
            size--;
            return ;
        }
        while (temp!=null)
        {
            if(temp.data==dataToBeRemove)
            {
                temp2.next=temp.next;
                found = true;
                size--;
                return ;
            }
            temp2 = temp;
            temp = temp.next;

        }
        if (found != true)
        {
            throw new ElementNotFoundException("Element is not available in List.");
        }
    }

    // Method for removing an element of given position.

    void removeAt(int position) throws ElementNotFoundException
    {
        Node temp = head;
        Node temp2 = null;
        int count = 1;
        boolean found = false;
        if ( head == null)
        {
            System.out.println("List is empty.");
            return ;
        }
        if( position == 1 )
        {
            temp = temp.next;
            head = temp;
            size--;
            return ;
        }
        while (temp!=null)
        {
            if(count==position)
            {
                temp2.next=temp.next;
                found = true;
                size--;
                return ;
            }
            temp2 = temp;
            temp = temp.next;
            count++;
        }
        if (found == false)
        {
            throw new ElementNotFoundException("Element is not available in List.");
        }
    }


    // Method for removing an element from all occurrences.

    void removeAll(T dataToBeRemove) throws ElementNotFoundException
    {
        Node temp = head;
        Node temp2 = null;
        boolean found = false;
        if ( head == null)
        {
            System.out.println("List is empty.");
            return ;
        }
        if( temp.data == dataToBeRemove)
        {
            while(temp.data==dataToBeRemove) /* This loop is used for situation
                                                when there are multiple same elements
                                                at the beginning of list, in that situation we have to
                                                change head again and again.*/
            {
                temp = temp.next;
                head = temp;
                found = true;
                size--;
            }
        }
        while (temp!=null)
        {
            if(temp.data==dataToBeRemove && temp.next.data == dataToBeRemove) /* This condition is for the situation
                                                                            when dataToBeRemove occur one after another */
            {
                    found = true;
                    while(temp.data == dataToBeRemove)
                    {
                        temp = temp.next;
                        size--;
                    }
                    temp2.next = temp;
            }
            else if(temp.data == dataToBeRemove)
            {
                temp2.next = temp.next;
                size--;
                found = true;
            }
            temp2 = temp;
            temp = temp.next;
        }
        if (found == false)
        {
            throw new ElementNotFoundException("Element is not available in List.");
        }
    }

    // Method of removing last occurrence in a LinkedList.

    void removeLast(T dataToBeRemove) throws ElementNotFoundException
    {
     int position = FindLastOccurrence(dataToBeRemove);
     int count = 1;
     Node temp = head;
     Node temp2 = null;
     boolean found = false;
     if ( position == 1)
     {
         temp = head.next;
         head = temp;
         size--;
         return ;
     }
     while(temp!=null)
     {
         if (count == position)
         {
             temp2.next = temp.next;
             size--;
             found = true;
         }
         temp2 = temp;
         temp = temp.next;
         count++;
     }
     if ( found == false)
     {
         throw new ElementNotFoundException("Element is not available in List.");
     }
    }

    // Method for update an element in LinkedList.

    void update(T updatedData , T dataToBeReplace) throws ElementNotFoundException
    {
        Node temp = head;
        boolean found = false;
        if (head == null)
        {
            System.out.println("List is empty.");
            return ;
        }
        while(temp != null)
        {
            if(temp.data == dataToBeReplace)
            {
                temp.data=updatedData;
                return ;
            }
            temp = temp.next;
        }
        if (found == false)
        {
            throw new ElementNotFoundException("Element is not available in List.");
        }
    }

    // Method for update an element at all occurrences in LinkedList.

    void updateAll(T updatedData , T dataToBeReplace) throws ElementNotFoundException
    {
        Node temp = head;
        boolean found = false;
        if (head == null)
        {
            System.out.println("List is empty.");
            return ;
        }
        while(temp != null)
        {
            if(temp.data == dataToBeReplace)
            {
                temp.data=updatedData;
                found = true;
            }
            temp = temp.next;
        }
        if (found != true)
        {
            throw new ElementNotFoundException("Element is not available in List.");
        }
    }
}