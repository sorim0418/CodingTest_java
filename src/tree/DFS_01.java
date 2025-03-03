package tree;
/*
재귀함수로 트리의 운행 구현(dfs 워밍업)
중위 호출 순서 : 2i → i → 2i+1 (현재 노드가 부모라는 가정), 이진탐색할때 사용되는 탐색

후위 호출 순서 : 2i → 2i+1 → i (현재 노드가 부모라는 가정, 파일 삭제, 서브트리 크기 계산시 사용되는 탐색

전위 호출 순서 : i → 2i → 2i + 1, 트리 복사, 컴파일러 구문 분석

노드 = [ 1234567]
결과는 String[]
결과 =>["1245367","4251637,"4526731"] 전위 중위 후위
 */
class DFS_01 {
    public static String[] node = {" 1234567"};
    public static int size = node[0].length();

    public static String preOrder(int index) {
        if (index >= size) return ""; // 종료 조건

        String result = String.valueOf(node[0].charAt(index)); //현재노드 방문 -> 부모, index를 상수로 넣을때 주의
        result += preOrder(index * 2); // 왼쪽 방문 (재귀 호출)
        result += preOrder((index * 2) + 1); // 오른쪽 방문 (재귀 호출)

        return result;
    }

    public static String inOrder(int index) {
        if (index >= size) return ""; // 종료 조건

        String result = "";
        result += inOrder(index * 2); // 왼쪽 방문 (재귀 호출)
        result += String.valueOf(node[0].charAt(index)); //현재노드 방문 -> 부모
        result += inOrder((index * 2) + 1); // 오른쪽 방문 (재귀 호출)

        return result;
    }

    public static String postOrder(int index) {
        if (index >= size) return ""; // 종료 조건

        String result = "";
        result += postOrder(index * 2); // 왼쪽 방문 (재귀 호출)
        result += postOrder((index * 2) + 1); // 오른쪽 방문 (재귀 호출)
        result += String.valueOf(node[0].charAt(index)); //현재노드 방문 -> 부모
        return result;
    }
}
