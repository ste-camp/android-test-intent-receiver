// ServiceInterface.aidl
package it.neslab.intentreceiver;

// Declare any non-default types here with import statements

interface ServiceInterface {

    long getCallTime(long start, int mode, int n_tests);
}
