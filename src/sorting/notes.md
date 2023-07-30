
**Stability :** Stability in sorting algorithms refers to the property that if two elements have equal
keys (values to be sorted), the algorithm maintains their relative order as they appear in the input.
<br/>
In other words, if you have two elements with the same value, and one comes before the other in the
original list, a stable sorting algorithm will ensure that the element which came first will still appear
first after sorting.


**1. Bubble Sort**

_**Time Complexity**_ 
<br/>
Best : O(n) 
<br/>
Worst : O(n2) 
<br/>
Average:  O(n2) 
<br/>
<br/>
_**Space Complexity**_ : O(1)
<br/>
Stability : Yes

_**Cheat code**_: Compare two Adjacent values in each iteration and swap

<br/>

**2. Insertion Sort**

_**Time Complexity**_
<br/>
Best : O(n)
<br/>
Worst : O(n2)
<br/>
Average:  O(n2)
<br/>
<br/>
_**Space Complexity**_ : O(1)
<br/>
Stability : Yes

_**Cheat code**_:  first value is already sorted, select an unsorted value.
compare both , greater place right else left also compare with other values and update the place.


**3. Selection Sort**

_**Time Complexity**_
<br/>
Best : O(n2)
<br/>
Worst : O(n2)
<br/>
Average:  O(n2)
<br/>
<br/>
_**Space Complexity**_ : O(1)
<br/>
Stability : No

_**Cheat code**_: Swap the minimum value Index with Current Iteration Index


**4. Quick Sort**

_**Time Complexity**_
<br/>
Best : O(n*log(n))
<br/>
Worst : O(n2)
<br/>
Average:  O(n*log(n))
<br/>
<br/>
_**Space Complexity**_ : O(log n)
<br/>
Stability : No

_**Cheat code**_: divide and conquer , small values of Pivot should be left and large values on right 


**5. Merge Sort**

_**Time Complexity**_
<br/>
Best : O(n*log(n))
<br/>
Worst :O(n*log(n))
<br/>
Average:  O(n*log(n))
<br/>
<br/>
_**Space Complexity**_ : O(log n)
<br/>
Stability : Yes

_**Cheat code**_: divide , conquer , combine

**6. Heap Sort**

_**Time Complexity**_
<br/>
Best : O(n*log(n))
<br/>
Worst :O(n*log(n))
<br/>
Average:  O(n*log(n))
<br/>
<br/>
_**Space Complexity**_ : O(1)
<br/>
Stability : No

_**Cheat code**_: Complete binary Tree,
Insert ( swap if parent is less than child), 
delete (swap root with last element and then do construct max heap again)