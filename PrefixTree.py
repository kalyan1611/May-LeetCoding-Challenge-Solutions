class Trie:
    
    dictionary = {}

    def __init__(self):
        self.dictionary = {}
        self.dictionary['#'] = True
        

    def insert(self, word: str) -> None:
        prev = self.dictionary
        for i in word:
            if i not in prev:
                prev[i] = {}
            prev = prev[i]
        prev['#'] = True
        

    def search(self, word: str) -> bool:
        prev = self.dictionary
        for i in word:
            if i not in prev:
                return False
            else:
                prev = prev[i]
        return '#' in prev       

    def startsWith(self, prefix: str) -> bool:
        prev = self.dictionary
        for i in prefix:
            print(i)
            if i not in prev:
                return False
            else:
                prev = prev[i]
        return True
