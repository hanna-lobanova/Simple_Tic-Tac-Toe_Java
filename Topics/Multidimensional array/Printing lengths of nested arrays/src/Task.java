What does this code print?

int[][] c = {
        { 40, 30, 25, 30, 15},
        { 13, 12, 16 },
        { 101, 125, 114, 131 }
}; 

System.out.print(c.length + " ");

for (int[] nestedArray : c) {
        System.out.print(nestedArray.length + " ");
}