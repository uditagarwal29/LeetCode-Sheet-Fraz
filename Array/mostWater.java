package Arrays;

//2 factors contribute in maximizing the area of water stored : , width between two pillars and the height of pillars
//we start off by taking max width, i.e pillars at pointer 1 (start index) and pointer 2(end index) 
// we calculate area by multiplyinh the min of the two pillars(so water dont spill) and the width b/w pillars.
//compare it with max area till now, update if it is bigger than it
// now we start maximizing the height of pillar for which we have to  compromise width
//if pillar at pointer 2 is smaller of the two pillar, move to pillar before it
//if pillar at pointer 1 is smaller of the two pillar, move to pillar next to it
public class mostWater {
    public static void main(String[] args) {
        int height[] = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        int s = 0;
        int e = height.length - 1;
        int max_Area = Integer.MIN_VALUE;
        int curr_Area = 0;
        while (s < e) {
            curr_Area = Math.min(height[s], height[e]) * (e - s);
            max_Area = Math.max(curr_Area, max_Area);
            if (height[s] >= height[e]) {
                e--;
            } else {
                s++;
            }
        }
        System.out.println(max_Area);
    }
}
