# ReversibleHashMap

ReversibleHashMap is a special type that allows you to get reversed HashMap without iterating over all keys. It works by
storing a copy of HashMap and changing the reversed HashMap values when the original HashMap values changes.

Example usage can be found in tests.