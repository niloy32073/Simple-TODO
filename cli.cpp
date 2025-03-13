#include <iostream>
#include <cstdlib>

using namespace std;

int main() {
    string commitMessage = "Auto commit from C++ program";
    
    // Run Git commands sequentially
    int status = 0;
    
    status = system("git add .");
    if (status != 0) {
        cerr << "Error: Failed to add changes." << endl;
        return 1;
    }
    
    status = system(("git commit -m \"" + commitMessage + "\"").c_str());
    if (status != 0) {
        cerr << "Error: Failed to commit changes." << endl;
        return 1;
    }
    
    status = system("git push origin main");
    if (status != 0) {
        cerr << "Error: Failed to push changes." << endl;
        return 1;
    }
    
    cout << "Changes pushed successfully!" << endl;
    return 0;
}
