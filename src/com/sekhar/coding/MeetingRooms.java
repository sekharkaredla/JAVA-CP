package com.sekhar.coding;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (firstValue, secondValue) -> firstValue[0] - secondValue[0]);
        PriorityQueue<Integer> meetingEndingTimes = new PriorityQueue<>();
        for (int[] eachMeeting : intervals) {
            if (meetingEndingTimes.isEmpty()) {
                meetingEndingTimes.add(eachMeeting[1]);
                continue;
            }
            if (eachMeeting[0] >= meetingEndingTimes.peek())
                meetingEndingTimes.poll();
            meetingEndingTimes.add(eachMeeting[1]);
        }
        return meetingEndingTimes.size();
    }
}
