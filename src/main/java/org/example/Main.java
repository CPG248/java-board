package org.example;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        CommandSupport cmdSup = new CommandSupport();
        String cmd;

        ArrayList<String> boardNames = new ArrayList<String>();
        ArrayList<String> boardContents = new ArrayList<String>();

        while (true) {
            System.out.println("명령어를 입력하세요");
            cmd = scan.nextLine();
            if (cmd.equals("exit")) {
                break;
            }
            else if (cmd.equals("add")) {
                String strName;
                String strContent;
                System.out.print("게시물 제목을 입력해주세요");
                strName = scan.nextLine();
                while(true) {
                    if(strName.equals(" ") || strName.equals("")) {
                        strName = scan.nextLine();
                        System.out.println("제목은 내용이 있어야 합니다.");
                    }
                    else
                        break;
                }
                System.out.println("게시물 내용을 입력해주세요");
                strContent = scan.nextLine();

                boardNames.add(strName);
                boardContents.add(strContent);
                System.out.println("게시물을 등록하였습니다.\n");
                System.out.println("==================");
                System.out.println("제목 : " + strName);
                System.out.println(strContent);

            }
            else if (cmd.equals("list")) {
                if (cmdSup.CheckBoardNull(boardNames))
                    continue;
            }
            else if (cmd.equals("update")) {
                if(cmdSup.CheckBoardNull(boardNames))
                    continue;
                else
                    System.out.println("==================\n\n");

                System.out.print("수정할 게시글 번호 : " );
                int idx = Integer.parseInt(scan.nextLine());

                if (idx + 1 > boardNames.size() || boardNames.get(idx).equals(" ")) {
                    System.out.println(idx + " 번쨰 게시물이 없습니다.");
                    continue;
                }  else {
                    System.out.println("==================");
                    String strName;
                    String strContent;
                    System.out.print("제목 : ");
                    strName = scan.nextLine();
                    while(true) {
                        if(strName.equals(" ") || strName.equals("")) {
                            System.out.println("제목은 내용이 있어야 합니다.");
                            strName = scan.nextLine();
                        }
                        else
                            break;
                    }
                    System.out.print("내용 : ");
                    strContent = scan.nextLine();

                    System.out.println(idx + " 번째 게시물이 수정되었습니다.");
                    boardNames.set(idx, strName);
                    boardContents.set(idx, strContent);
                }
            }
            else if (cmd.equals("delete")) {
                if(cmdSup.CheckBoardNull(boardNames))
                    continue;
                else
                    System.out.println("==================\n\n");

                System.out.print("삭제할 게시글 번호 : ");
                int idx = Integer.parseInt(scan.nextLine());
                System.out.println(idx);

                if (idx + 1 > boardNames.size() || boardNames.get(idx).equals(" ")) {
                    System.out.println(idx + " 번쨰 게시물이 없습니다.");
                    continue;
                }  else if (idx + 1 == boardNames.size()) {
                    boardNames.remove(idx);
                }
                else {
                    boardNames.set(idx, " ");
                    boardContents.set(idx, " ");
                }
                System.out.println(idx + " 번째 게시물이 삭제되었습니다.");

            } else if (cmd.equals("detail")) {
                if(cmdSup.CheckBoardNull(boardNames))
                    continue;
                else
                    System.out.println("==================\n\n");

                System.out.print("상세히 볼 제목 : ");
                int idx = Integer.parseInt(scan.nextLine());
                System.out.println(idx);

                if (idx + 1 > boardNames.size() || boardNames.get(idx).equals(" ")) {
                    System.out.println(idx + " 번쨰 게시물이 없습니다.");
                } else {
                    System.out.println("제목 : " + boardNames.get(idx));
                    System.out.println(boardContents.get(idx));
                }
            }
            else {
                System.out.println("해당되는 명령어가 없습니다.");
            }
            System.out.println("==================\n\n");
        }

    }
}

class CommandSupport
{
    public boolean CheckBoardNull(ArrayList<String> boardNames)
    {
        int count = 0;
        for (int i = 0; i < boardNames.size(); i++) {
            if(boardNames.get(i).equals(" "))
                continue;
            System.out.println("==================");
            System.out.println(i + "     |" + boardNames.get(i));
            count++;
        }

        if(count == 0) {
            System.out.println("오류 : 게시글이 없습니다");
            return true;
        }
        return false;
    }
}


