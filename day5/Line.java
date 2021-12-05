import java.awt.Point;

public class Line {
    private Point startPoint = new Point();
    private Point endPoint = new Point();

    public Line(int x1, int y1, int x2, int y2) {
        this.startPoint.x = x1;
        this.startPoint.y = y1;
        this.endPoint.x = x2;
        this.endPoint.y = y2;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public Point[] getPoints() {
        int maxX = Math.max(startPoint.x, endPoint.x);
        int minX = Math.min(startPoint.x, endPoint.x);
        int maxY = Math.max(startPoint.y, endPoint.y);
        int minY = Math.min(startPoint.y, endPoint.y);
        Point[] pList;
        int index = 0;

        if (maxX - minX == 0){
            pList = new Point[maxY-minY+1];
            for (int i = 0; i < maxY-minY +1; i++)
                pList[index++] = new Point(maxX, i+minY);
        } else if(maxY - minY == 0) {
            pList = new Point[maxX-minX+1];
            System.out.println(pList.length);
            for (int i = 0; i < maxX-minX +1; i++)
                pList[index++] = new Point(i+minX, maxY);
        } else {
            pList = new Point[maxX - minX + 1];
            if ((startPoint.x < endPoint.x  && startPoint.y < endPoint.y) || 
                    (startPoint.x > endPoint.x && startPoint.y > endPoint.y))
                for(int i = 0; i < maxX-minX+1; i++, index++) {
                    pList[index] = new Point(minX+i, minY+i);
                }
            else
                for (int i = 0; i < maxX-minX+1; i++, index++)
                    pList[index] = new Point(maxX-i, minY+i);
        }
        System.out.println("index: " + index + "        pList's size: " + pList.length);
        
        for (Point p : pList)
            if (p == null){
                System.out.println("p is null here");
                break;}
        return pList;

        // for (int i = 0, index = 0; i < maxX-minX + 1; i++) {
        //     if (startPoint.x == minX) {
        //         for (int j = 0; j < maxY - minY + 1; j++, i++, index++)
        //             pList[index] = new Point(i+minX, j+minY);
        //     } else {
        //         for (int j = 0; j < maxY - minY + 1; j++, i++, index++)
        //             pList[index] = new Point(i+minX, maxY-j);
        //     }
        // }
        // return pList;
    }
}
