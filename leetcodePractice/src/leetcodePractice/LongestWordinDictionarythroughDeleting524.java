package leetcodePractice;

import java.util.LinkedList;
import java.util.List;

public class LongestWordinDictionarythroughDeleting524 {
public static  String findLongestWord(String s, List<String> d) {
	String longest = "";
	for(String target : d ) {
		if(!isMatched(s, target)) continue;
		if(longest.length()<target.length()||(longest.length()==target.length()&&target.compareTo(longest)<0)){
			longest = target;
		}
	}
        return longest;
    }

public static boolean  isMatched(String source, String target) {
	int pointerSource = 0;
	int pointerTarget = 0;
	while(pointerSource<source.length()&&pointerTarget<target.length()) {
		if(source.charAt(pointerSource) == target.charAt(pointerTarget)) {
			pointerTarget++;
		}
		pointerSource++;
	}
	if(pointerTarget==target.length()) {
		return true;
	}
	return false;
}

public static void main(String[] args) {
	String s = "abpcplea";
	LinkedList<String> d = new LinkedList<>();
	d.add("ale");
	d.add("apple");
	d.add("monkey");
	d.add("plea");
	d.add("pcplea");
	System.out.println(findLongestWord(s, d));
}
}
/*
Input:
s = "abpcplea", d = ["ale","apple","monkey","plea"]
Output: 
"apple"
*/
