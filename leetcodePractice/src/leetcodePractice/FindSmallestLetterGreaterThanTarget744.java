package leetcodePractice;

public class FindSmallestLetterGreaterThanTarget744 {
	public static char nextGreatestLetter(char[] letters, char target) {
        if(target - letters[letters.length-1]>=0) return letters[0];
        int i = 0;
        while(i<letters.length&&letters[i]-target<=0) i++;
        return letters[i];
    }
	public static void main(String[] args) {
		char[] letters = {'c', 'f', 'j'};
		char target = 'd';
		System.out.println(nextGreatestLetter(letters, target));
	}
}
