//
// Created by jun on 2020/6/27.
//

#ifndef CPPSERIES_LISTNODE_H
#define CPPSERIES_LISTNODE_H
#include <istream>

struct ListNode {
    int val;
    ListNode *next;

    ListNode(int x) : val(x), next(NULL) {}
};

#endif //CPPSERIES_LISTNODE_H
